package baekjoon_java.GoldV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_15989_123더하기4 { //dp(다이나믹 프로그래밍)
    static int[] arr;
    static int[] dp;
    static int T;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        arr = new int[T];
        int maxN = 0;
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxN = Math.max(maxN, arr[i]);
        }
        dp = new int[maxN + 1];
        dp();
        for (int i = 0; i < T; i++) {
            System.out.println(dp[arr[i]]);
        }

    }

    public static void dp() {
        dp[0] = 1;

        for (int j = 1; j <= 3; j++) {
            for (int i = 1; i < dp.length; i++) {
                if (i - j >= 0) {
                    dp[i] += dp[i - j];
                }
            }
        }
    }
}
