package baekjoon_java.BronzeII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/2231 브루트포스 알고리즘
메모리: 14188KB , 시간: 140ms
 */
public class 분해합 {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = 0;

        for (int i = 1; i <= N; i++) {
            int sum = 0, num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if (sum + i == N) {
                M = i;
                break;
            }
        }

        System.out.println(M);
    }
}
