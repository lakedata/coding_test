package baekjoon_java.SilverIV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class boj_1331_나이트투어 { //유형: 구현, 메모리제한: 128MB, 시간 제한: 2초
    private static final int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    private static final int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] visited = new boolean[6][6];
        int[] prev = new int[2];
        Arrays.fill(prev, -1);
        int firstx = 0;
        int firsty = 0;

        for (int i = 0; i < 36; i++) {
            String knightMove = br.readLine();
            int x = knightMove.charAt(0) - 'A';
            int y = knightMove.charAt(1) - '1';

            if (i == 0) {
                firstx = x;
                firsty = y;
            }

            // 현재위치와 직전 위치 고려
            if (prev[0] != -1 && !checkMove(prev, new int[]{x, y})) {
                System.out.println("Invalid");
                return;
            }

            if (visited[x][y]) { // 모든 칸 한 번씩
                System.out.println("Invalid");
                return;
            }

            visited[x][y] = true;

            prev[0] = x;
            prev[1] = y;

            if (i == 35) { // 처음 위치와 마지막 위치 이동 고려
                if (!checkMove(new int[]{firstx, firsty}, new int[]{prev[0], prev[1]})) {
                    System.out.println("Invalid");
                    return;
                }
            }
        }

        System.out.println("Valid");
    }

    private static boolean checkMove(int[] prev, int[] next) {
        for (int j = 0; j < 8; j++) {
            int nx = prev[0] + dx[j];
            int ny = prev[1] + dy[j];

            if (nx < 0 || nx >= 6 || ny < 0 || ny >= 6)
                continue;

            if (nx == next[0] && ny == next[1]) {
                return true;
            }
        }
        return false;
    }
}
