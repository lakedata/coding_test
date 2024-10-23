package baekjoon_java.BronzeII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_8958_OX퀴즈 {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String arr = br.readLine();
            int sum = 0, cnt = 1;
            for (int j = 0; j < arr.length(); j++) {
                if (arr.charAt(j) == 'O') {
                    sum += cnt;
                    cnt++;
                } else cnt = 1;
            }
            System.out.println(sum);
        }
    }
}

