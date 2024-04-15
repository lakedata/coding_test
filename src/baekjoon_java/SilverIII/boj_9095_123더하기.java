package baekjoon_java.SilverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9095_123더하기 { //문제유형: 다이나믹 프로그래밍 , 메모리 제한: 512MB, 시간 제한: 1초

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        int dp[] = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 0; i < tc; i++) {
            int N = Integer.parseInt(br.readLine());

            for (int j = 4; j <= N; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }
            System.out.println(dp[N]);
        }
    }
}
