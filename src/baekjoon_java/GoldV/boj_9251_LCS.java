package baekjoon_java.GoldV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9251_LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        int aLen = a.length;
        int bLen = b.length;
        int[][] lcs = new int[aLen + 1][bLen + 1];


        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (a[i-1] == b[j-1])
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                else lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
            }
        }
        System.out.println(lcs[aLen][bLen]);
    }
}
