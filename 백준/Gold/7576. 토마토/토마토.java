import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static int[] dx = {0, 0, -1, 1};//왼쪽, 오른쪽, 앞, 뒤 
    static int[] dy = {-1, 1, 0, 0};
    static int[][] board;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // 가로
        n = Integer.parseInt(st.nextToken()); // 세로

        board = new int[n][m];
        Queue<Point> que = new LinkedList<>();

        for(int x = 0; x < n; x++) {
            st = new StringTokenizer(br.readLine());
            for(int y = 0; y < m; y++) {
                    board[x][y] = Integer.parseInt(st.nextToken());
                    if(board[x][y] == 1) {
                        que.add(new Point(x, y)); // 익은 토마토 위치 큐에 삽입
                    }
            }
        }

        // BFS
        while(!que.isEmpty()) {
            Point cur = que.poll();
            for(int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(board[nx][ny] != 0) continue;

                board[nx][ny] = board[cur.x][cur.y] + 1;
                que.add(new Point(nx, ny));
            }
        }

        int result = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (board[x][y] == 0) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, board[x][y]);
            }
        }
        System.out.println(result - 1);
    }
}