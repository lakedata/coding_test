package baekjoon_java.BronzeII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10870_피보나치수5 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(N));
    }

    public static int fibonacci(int N) {
        int[] F = new int[N];

        if (N <= 1)
            return N;

        return fibonacci(N - 1) + fibonacci(N - 2);
    }

}
