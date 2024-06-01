package baekjoon_java.SilverⅡ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11060_점프점프 {
    private static final int MAX = 1001;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());


        int[] dp = new int[n + 1];
        Arrays.fill(dp, MAX);
        dp[1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j < i + 1 + arr[i]; j++) {
                if (j > n) break;
                dp[j] = Math.min(dp[i] + 1, dp[j]);
            }
        }
        System.out.println(dp[n] == MAX ? -1 : dp[n]);
    }
}
