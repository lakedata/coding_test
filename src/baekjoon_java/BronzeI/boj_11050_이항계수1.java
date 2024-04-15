package baekjoon_java.BronzeI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11050_이항계수1 { //문제유형: 조합론 , 메모리 제한: 256MB, 시간 제한: 1초
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = fact(N) / (fact(N - K) * fact(K));
        System.out.println(answer);
    }

    public static int fact(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fact(n - 1);
    }
}
