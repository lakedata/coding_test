package baekjoon_java.GoldIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1987_알파벳 { //유형: DFS + 백트래킹, 메모리제한: 256 MB, 시간 제한: 2초
    static int R, C;
    static int[][] map;
    static boolean[] visited = new boolean[26];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int max = 1;

    public static void main(String argsp[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); //세로
        C = Integer.parseInt(st.nextToken()); //가로
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }
        dfs(0, 0, 0); // (0,0)부터 시작하며, 현재 이동한 위치는 0회

        System.out.println(max);
    }

    public static void dfs(int x, int y, int cnt) {
        if (visited[map[x][y]]) {
            max = Math.max(max, cnt);
            return;
        } else {
            visited[map[x][y]] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C)
                    continue;

                dfs(nx, ny, cnt + 1);
            }
        }
        visited[map[x][y]] = false;
    }
}
