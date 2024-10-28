import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] mindp = new long[101];

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Arrays.fill(mindp, Long.MAX_VALUE);

            mindp[2] = 1;
            mindp[3] = 7;
            mindp[4] = 4;
            mindp[5] = 2;
            mindp[6] = 6;
            mindp[7] = 8;
            mindp[8] = 10;
            mindp[9] = 18;
            mindp[10] = 22;

            String[] add = { "1", "7", "4", "2", "0", "8" }; //남은 성냥
            if(n >= 11) {
                for (int j = 11; j <= 100; j++) {
                    for (int k = 2; k <= 7; k++) {
                        String str = "" +  mindp[j - k] + add[k - 2];
                        mindp[j] = Math.min(mindp[j], Long.parseLong(str));
                    }
                }
            }
            System.out.print(mindp[n]);
            
            //가장 큰 수
            StringBuilder max = new StringBuilder();
            if(n % 2 == 0) { // 짝수
                while(n > 0) {
                    max.append("1"); n -= 2;
                }
            } else {
                max.append("7"); n -= 3;
                while(n > 0) { // 홀수
                    max.append("1"); n -= 2;
                }
            }
            System.out.print(" " + max.toString() + "\n");
        }
    }
}