package baekjoon_java.SilverⅡ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16953 {
    static long A, B;
    static int min = Integer.MAX_VALUE;

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        func(A, 1);
        System.out.println(min == Integer.MAX_VALUE ? - 1: min);
    }
    public static void func(long current, int count) {
        if(current == B) {
            min = count;
            return;
        }
        if(current > B)
            return;

        func(current * 2, count + 1);
        func(current * 10 + 1, count + 1);
    }
}
