import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int col, row;
    static int[][] arr;
    static Queue<Pair> que = new LinkedList<>();

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String argp[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken()); //가로
        col = Integer.parseInt(st.nextToken()); //세로

        arr = new int[col][row];
        for (int i = 0; i < col; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < row; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    que.add(new Pair(i, j)); //시작점이 여러 개
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        while (!que.isEmpty()) {
            Pair cur = que.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= col || ny < 0 || ny >= row) continue;

                if (arr[nx][ny] == 0) {
                    que.add(new Pair(nx, ny));
                    arr[nx][ny] = arr[cur.x][cur.y] + 1;
                }
            }
        }

        int day = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (arr[i][j] == 0) {
                    return -1;
                }
                day = Math.max(day, arr[i][j]);
            }
        }
        return day - 1;
    }
}
