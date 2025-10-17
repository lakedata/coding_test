import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int []T = new int[N + 1];
        int []P = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken()); // 상담 기간
            P[i] = Integer.parseInt(st.nextToken()); // 상담 금액
        }

        int[] DP = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            // 상담 안 하는 경우  
            DP[i + 1] = Math.max(DP[i + 1], DP[i]);

            // 상담을 하는 경우
            int next = i + T[i];
            if (next <= N + 1) {
                DP[next] = Math.max(DP[next], DP[i] + P[i]);
            }
        }

        System.out.println(DP[N + 1]);//마지막날(N일)이 T=1이라면 일을 할 수 있음
    }
}