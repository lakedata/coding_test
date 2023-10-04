package baekjoon_java.SilverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로만들기 {//1463번 dp
    static int N;
    static Integer[] dp;

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new Integer[N + 1];

        dp[1] = 0;//dp초기화

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;// +1은 연산을 수행한 카운터를 하나 올려줌

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);// 나누기 3 연산 수행할 경우와 -1 연산 수행한 경우 비교
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);// 나누기 3 연산 수행할 경우와 -1 연산 수행한 경우 비교
            }
        }
        System.out.println(dp[N]);
    }

}
