package baekjoon_java.SilverI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 쉬운계단수 {// dp 18944번
    static long[][] dp;
    static long mod = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new long[N + 1][10];

        //N=1 경우의 수
        for (int i = 0; i < 9; i++) {
            dp[1][i] = 1;
        }

        //N>1
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1] % mod;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1] % mod;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }

            }
        }
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[N][i];
        }
        //System.out.println(sum); 아님 주의
        System.out.println(sum % mod);
    }
}
