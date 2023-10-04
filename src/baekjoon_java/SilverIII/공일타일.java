package baekjoon_java.SilverIII;

import java.io.*;

public class 공일타일 {//1904번 01타일
    private static final int MOD = 15746;
    static int arr[] = new int[1000001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        System.out.print(DP(N));
    }

    // Bottom-Up
    private static int DP(int N) {
        for (int i = 3; i <= N; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % MOD;
        }

        return arr[N];
    }
}