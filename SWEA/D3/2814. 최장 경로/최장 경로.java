import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static int T, N, M, ans = Integer.MIN_VALUE;
    public static boolean[] visit;
    public static int[][] map;

    public static void main(String argp[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            ans = Integer.MIN_VALUE;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N + 1][N + 1];
            visit = new boolean[N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                map[n1][n2] = map[n2][n1] = 1;
            }

            for (int i = 1; i <= N; i++) {
                dfs(i, 1);
                visit[i] = false;
            }
            System.out.println("#" + tc + " " + ans);
        }
    }

    public static void dfs(int num, int cnt) {
        visit[num] = true;

        for (int i = 1; i <= N; i++) {
            if (i == num) continue; //같은 수 끼리의 비교인가?

            if (map[num][i] == 1 && !visit[i]) {
                //방문처리
                dfs(i, cnt + 1);
                visit[i] = false;
            }
        }
        ans = Math.max(ans, cnt);
    }
}
