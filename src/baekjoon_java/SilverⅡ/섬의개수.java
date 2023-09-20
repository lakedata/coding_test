package baekjoon_java.SilverⅡ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 섬의개수 {
    static int[][] map;
    static boolean[][] visit; // 방문체크
    static int w, h; /// 너비(가로), 높이(세로)
    static int dx[] = {0, 0, -1, 1, -1, -1, 1, 1};
    static int dy[] = {-1, 1, 0, 0, -1, 1, -1, 1}; //8방향 탐색

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) //00
                break;

            map = new int[h + 1][w + 1];
            visit = new boolean[h + 1][w + 1];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < w; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            int count = 0; // 구역 수

            // dfs 탐색 시작하고, 구역 수 증가
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    // dfs 탐색하고 구역 수 1 증가
                    if (map[i][j] == 1 && !visit[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            //범위 안에 있으면서
            if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                // 방문하지 않았으면 dfs 탐색
                if (map[nx][ny] == 1 && !visit[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
