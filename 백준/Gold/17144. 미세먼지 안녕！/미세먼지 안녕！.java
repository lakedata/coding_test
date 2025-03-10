import java.util.*;
import java.io.*;

class Main {
    static int r, c, t;
    static int[][] arr, temp;
    static int airCleanerTop, airCleanerBottom;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        arr = new int[r][c];

        boolean found = false;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1 && !found) {
                    airCleanerTop = i;
                    airCleanerBottom = i + 1;
                    found = true;
                }
            }
        }

        while (t-- > 0) {
            spreadDust();
            operateCleaner();
        }

        System.out.println(getTotalDust());
    }

    static void spreadDust() {
        temp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] > 0) {
                    int spreadAmount = arr[i][j] / 5;
                    int spreadCount = 0;

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];

                        if (nx >= 0 && ny >= 0 && nx < r && ny < c && arr[nx][ny] != -1) {
                            temp[nx][ny] += spreadAmount;
                            spreadCount++;
                        }
                    }
                    temp[i][j] += arr[i][j] - (spreadAmount * spreadCount);
                }
            }
        }
        temp[airCleanerTop][0] = temp[airCleanerBottom][0] = -1;
        arr = temp;
    }

    static void operateCleaner() {
        // 위쪽 공기청정기 (반시계 방향)
        for (int i = airCleanerTop - 1; i > 0; i--) arr[i][0] = arr[i - 1][0];
        for (int i = 0; i < c - 1; i++) arr[0][i] = arr[0][i + 1];
        for (int i = 0; i < airCleanerTop; i++) arr[i][c - 1] = arr[i + 1][c - 1];
        for (int i = c - 1; i > 1; i--) arr[airCleanerTop][i] = arr[airCleanerTop][i - 1];
        arr[airCleanerTop][1] = 0;

        // 아래쪽 공기청정기 (시계 방향)
        for (int i = airCleanerBottom + 1; i < r - 1; i++) arr[i][0] = arr[i + 1][0];
        for (int i = 0; i < c - 1; i++) arr[r - 1][i] = arr[r - 1][i + 1];
        for (int i = r - 1; i > airCleanerBottom; i--) arr[i][c - 1] = arr[i - 1][c - 1];
        for (int i = c - 1; i > 1; i--) arr[airCleanerBottom][i] = arr[airCleanerBottom][i - 1];
        arr[airCleanerBottom][1] = 0;
    }

    static int getTotalDust() {
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] > 0) sum += arr[i][j];
            }
        }
        return sum;
    }
}