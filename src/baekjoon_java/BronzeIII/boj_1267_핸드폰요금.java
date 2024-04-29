package baekjoon_java.BronzeIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1267_핸드폰요금 {
    static int a = 0, b = 0;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int call = Integer.parseInt(st.nextToken());

            if (call % 30 >= 0) a += (call / 30 + 1) * 10;
            else a += (call / 30) * 10;

            if (call % 60 >= 0) b += (call / 60 + 1) * 15;
            else b += (call / 60) * 15;
        }

        if (a < b)
            System.out.println("Y " + a);
        else if (a > b)
            System.out.println("M " + b);
        else if (a == b)
            System.out.println("Y M " + a);
    }
}
