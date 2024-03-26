package baekjoon_java.SilverI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11660_구간합구하기5 { //누적합, 다이나믹 프로그래밍
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] xy = new int[M][4];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                xy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] prefix_sum = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                prefix_sum[i][j] = matrix[i - 1][j - 1] + prefix_sum[i - 1][j] + prefix_sum[i][j - 1] - prefix_sum[i - 1][j - 1];
            }
        }

        for (int i = 0; i < M; i++) {
            int x1 = xy[i][0];
            int y1 = xy[i][1];
            int x2 = xy[i][2];
            int y2 = xy[i][3];

            int value = prefix_sum[x2][y2] + prefix_sum[x1 - 1][y1 - 1] - prefix_sum[x2][y1 - 1] - prefix_sum[x1 - 1][y2];
            System.out.println(value);
        }
    }
}
