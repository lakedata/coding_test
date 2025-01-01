import java.io.*;

public class Main {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 0;

        int x = 2;
        while (x <= n) {
            dp[x] = dp[x - 1] + 1;
            if (x % 2 == 0) {
                dp[x] = Math.min(dp[x], dp[x / 2] + 1);
            }
            if(x % 3 == 0) {
                dp[x] = Math.min(dp[x], dp[x / 3] + 1);
            }
            x++;
        }
        System.out.println(dp[n]);
    }
}
