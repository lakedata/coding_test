import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9655_돌게임 {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1;
        }
        System.out.println(dp[n] % 2 == 0 ? "CY" : "SK");
    }

}
