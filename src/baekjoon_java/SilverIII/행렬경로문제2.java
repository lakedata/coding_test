package baekjoon_java.SilverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 행렬경로문제2 {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][n + 1];

        long cnt1 = matrix_path_rec(dp, n);
        long cnt2 = (long) n * n % MOD;

        System.out.println(cnt1 + " " + cnt2);
    }

    static long matrix_path_rec(long[][] dp, int n) {
        dp[1][1] = 1;
        long cnt1 = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != 1 || j != 1) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
                }
                cnt1 = (cnt1 + dp[i][j]) % MOD;
            }
        }

        return cnt1;
    }
}
