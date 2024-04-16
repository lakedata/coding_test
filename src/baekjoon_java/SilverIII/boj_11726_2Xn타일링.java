package baekjoon_java.SilverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11726_2Xn타일링 { //문제유형: 다이나믹 프로그래밍 , 메모리 제한: 512MB, 시간 제한: 1초
    static int[] memo;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        memo = new int[N + 1];

        System.out.println(dp(N));
    }
    public static int dp(int n) {
        if (n <= 2) return n;
        if (memo[n] != 0) return memo[n];

        memo[n] = (dp(n - 1) + dp(n - 2)) % 10007;
        return memo[n];
    }
}
