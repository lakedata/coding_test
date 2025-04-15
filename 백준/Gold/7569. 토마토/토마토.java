import java.util.*;
import java.io.*;

class Main {
    static int m, n, h;
    static int[][][] board;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static class Point {
        int x, y, z;
        Point(int z, int y, int x) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // 가로
        n = Integer.parseInt(st.nextToken()); // 세로
        h = Integer.parseInt(st.nextToken()); // 높이

        board = new int[h][n][m];
        Queue<Point> q = new LinkedList<>();

        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < m; x++) {
                    board[z][y][x] = Integer.parseInt(st.nextToken());
                    if (board[z][y][x] == 1) {
                        q.add(new Point(z, y, x)); // 익은 토마토 위치들 큐에 삽입
                    }
                }
            }
        }

        // BFS
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int dir = 0; dir < 6; dir++) {
                int nz = cur.z + dz[dir];
                int ny = cur.y + dy[dir];
                int nx = cur.x + dx[dir];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= m || ny >= n || nz >= h) continue;
                if (board[nz][ny][nx] != 0) continue;

                board[nz][ny][nx] = board[cur.z][cur.y][cur.x] + 1;
                q.add(new Point(nz, ny, nx));
            }
        }

        int result = 0;
        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (board[z][y][x] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(result, board[z][y][x]);
                }
            }
        }

        System.out.println(result - 1); // 1부터 시작했으므로 1 빼줌
    }
}