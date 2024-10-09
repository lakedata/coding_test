package baekjoon_java.SilverI;

import java.io.*;
import java.util.*;

public class boj_2178_미로탐색 {
    static int n, m;
    static String[] board;
    static int[][] dist;
    static int[] dx = {0, 0, -1, 1};  // L, R, U, D
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new String[n];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int startX, int startY) {
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(startX, startY));
        dist[startX][startY] = 0;

        while (!que.isEmpty()) {
            Pair cur = que.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + +dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (dist[nx][ny] >= 0 || board[nx].charAt(ny) != '1') continue;

                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                que.add(new Pair(nx, ny));
            }
        }

        return dist[n - 1][m - 1] + 1; // 목적지까지의 최단 거리에 +1을 해줘야 함
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
