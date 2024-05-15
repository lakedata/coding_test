package baekjoon_java.GoldV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14658_하늘에서별똥별이빗발친다 { //유형 : 브루트포스
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 가로
        int M = Integer.parseInt(st.nextToken()); // 세로
        int L = Integer.parseInt(st.nextToken()); // 한 변의 길이
        int K = Integer.parseInt(st.nextToken()); // 별똥별의 수

        int[] x = new int[K];
        int[] y = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                int count = 0;
                for (int k = 0; k < K; k++) {
                    int leftX = Math.min(x[i], x[j]);
                    int rightX = leftX + L;
                    int downY = Math.min(y[i], y[j]);
                    int topY = downY + L;

                    if (x[k] >= leftX && x[k] <= rightX && y[k] >= downY && y[k] <= topY) {
                        count++;
                    }
                }
                max = Math.max(max, count);
            }
        }
        System.out.println(K - max);
    }
}
