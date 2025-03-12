import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int [][]dp = new int[n+1][100];
        int []energy = new int[n+1]; // 체력
        int []joy = new int[n+1]; // 기쁨

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            energy[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            joy[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 99; j++) {    
                if(j < energy[i]) 
                    dp[i][j] = dp[i-1][j];
                else  {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-energy[i]] + joy[i]);
                }
            }
        }
        System.out.println(dp[n][99]);
    }
}