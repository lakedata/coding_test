package baekjoon_java.GoldV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_12865_평범한배낭 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int W[] = new int[N + 1]; //무게
        int V[] = new int[N + 1]; //가치

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                dp[i][j] = dp[i - 1][j];// 이전 행 결과 복사
                if (j - W[i] >= 0) { // 무게가 남으면
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - W[i]] + V[i]);// 더 큰 값으로 갱신
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
