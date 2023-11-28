package baekjoon_java.SilverI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2156_포도주시식 {
    static int arr[];
    static int n;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (n == 1) {
            System.out.println(arr[1]);
            return;
        }
        dp(arr);
        System.out.println(max);
    }

    public static void dp(int[] arrn) {
        int[] dp = new int[n + 1];
        dp[1] = arrn[1];
        dp[2] = arrn[1] + arrn[2];

        max = Math.max(dp[1], dp[2]);

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arrn[i], dp[i - 3] + arrn[i - 1] + arrn[i]));
            max = Math.max(max, dp[i]);
        }
    }
}
