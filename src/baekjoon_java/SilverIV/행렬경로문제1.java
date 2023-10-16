package baekjoon_java.SilverIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 24418번 행렬 경로 문제 1 (https://www.acmicpc.net/problem/24418)
 */
public class 행렬경로문제1 {
    static int m[][];
    static int cnt1 = 0, cnt2 = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        m = new int[n+1][n+1];//1,1부터 n,n까지 탐색하는거라서 n+1
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        matrix_path(m, n);
        matrix_path_dp(m, n);

        System.out.println(cnt1 + " " + cnt2);
    }

    static int matrix_path_rec(int[][] m, int i, int j) {
        // (1, 1) ~ (i, j)의 최고 점수
        if(i == 0 || j == 0) {
            cnt1++;
            return 0;
        } else {
            return m[i][j] + Math.max(matrix_path_rec(m, i-1, j), matrix_path_rec(m, i, j-1));
        }
    }
    static int matrix_path(int[][] m, int n) {
        return matrix_path_rec(m, n, n); // (1, 1) ~ (n, n)의 최고 점수;
    }

    static int matrix_path_dp(int[][] m, int n) {
        int[][] d = new int [n+1][n+1];

        for (int i = 0; i < n; i++) d[i][0] = 0;
        for (int j = 0; j < n; j++) d[0][j] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                cnt2++;
                d[i][j] = m[i][j] + Math.max(d[i - 1][j], d[i][j - 1]);
            }
        }
        return d[n][n];
    }

}
