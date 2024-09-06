package baekjoon_java.SilverI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1926_그림 {
    static int mx = 0;//그림의 최댓값
    static int num = 0;//그림의 수
    static int n, m;
    static int [][]board;
    static int []dx = {-1, 1, 0, 0};
    static int []dy = {0, 0, -1, 1};
    static boolean[][] vis = new boolean[502][502];
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.println(num + "\n" + mx);
    }
    public static void bfs() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(board[i][j] == 0 || vis[i][j]) continue;
                num++;
                Queue<Pair> que = new LinkedList<>();
                vis[i][j] = true;
                que.add(new Pair(i, j));
                int area = 0;
                while (!que.isEmpty()) {
                    Pair cur = que.poll();
                    area++;

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                        if (vis[nx][ny] || board[nx][ny] != 1) continue;

                        vis[nx][ny] = true;
                        que.add(new Pair(nx, ny));
                    }
                }
                mx = Math.max(mx, area);
            }
        }
    }
    static class Pair {
        int x,y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
