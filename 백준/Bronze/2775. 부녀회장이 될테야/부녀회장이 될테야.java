import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] dp = new int[15 + 1][15 + 1];

        for (int i = 1; i <= 15; i++) {
            dp[i][1] = 1;
            dp[0][i] = i;
        }

        for (int i = 1; i <= 15; i++) {
            for (int j = 2; j <= 15; j++) {    // 2호부터 14호까지
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호
            System.out.println(dp[k][n]);
        }
    }
}