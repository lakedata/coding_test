package baekjoon_java.SilverⅡ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11501_주식 { //그리디(탐욕법,최적의 값)
    static int N;
    static long[] stock;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long[] stock;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            stock = new long[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stock[j] = Integer.parseInt(st.nextToken());
            }
            System.out.println(fun(N, stock));
        }
    }

    public static long fun(int n, long[] stock) {
        long max = 0;
        long result = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (stock[i] > max) {
                max = stock[i];
            } else {
                result += max - stock[i];
            }
        }
        return result;
    }
}
