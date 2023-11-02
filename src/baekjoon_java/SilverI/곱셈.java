package baekjoon_java.SilverI;

import java.io.*;
import java.util.*;
/*
https://www.acmicpc.net/problem/1629
시간제한 0.5 , 메모리 14292KB, 시간 120ms
 */
public class 곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        System.out.print(exponentiation(a, b, c));
    }

    public static long exponentiation(long a, long b, long c) {
        if (b == 0) return 1;
        if (b % 2 == 1) {
            return (a * exponentiation(a, b - 1, c)) % c;
        }
        long k = exponentiation(a, b / 2, c) % c;
        return (k * k) % c;
    }
}
