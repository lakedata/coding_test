import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //집의 수

        int [][]dp = new int[n + 1][3];
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            if(i == 1) {
                dp[i][0] = red;
                dp[i][1] = green;
                dp[i][2] = blue;
            }

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + red; 
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + green; 
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + blue; 
        }
        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
    }
}