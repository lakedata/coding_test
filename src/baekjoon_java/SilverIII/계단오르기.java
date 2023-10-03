package baekjoon_java.SilverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 백준 2579 계단 오르기 (https://www.acmicpc.net/problem/2579)
 */
public class 계단오르기 {
    static int N;
    static Integer[] stair;
    static Integer[] dp;

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        stair = new Integer[N + 1];
        dp = new Integer[N + 1];

        for (int i = 1; i < N+1; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        //dp : 각 단계별 최댓값
        dp[0] = 0;
        dp[1] = stair[1];
        if (N >= 2) {
            dp[2] = stair[1] + stair[2];
        }

        for (int i = 3; i < N+1; i++) {
            // 1. 두 계단 + 한 계단 오른 경우
            // 2. 한 번에 두 계단 오른 경우
            dp[i] = Math.max(dp[i - 3] + stair[i - 1] + stair[i], dp[i - 2] + stair[i]);
        }

        System.out.println(dp[N]);
    }
}
