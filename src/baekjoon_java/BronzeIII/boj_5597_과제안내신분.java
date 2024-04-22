package baekjoon_java.BronzeIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_5597_과제안내신분 {
    public static void main(String argp[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean []arr = new boolean[31];

        Arrays.fill(arr, false);
        for (int i = 1; i <= 28; i++) {
            int N = Integer.parseInt(br.readLine());
            arr[N] = true;
        }

        for (int i = 1; i <= 30; i++) {
            if(!arr[i])
                System.out.println(i);
        }
    }
}
