package baekjoon_java.SilverIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1205_등수구하기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int new_score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int[] rank = new int[N];

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                rank[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(rank); //오름차순 정렬


            if (P == N && rank[0] >= new_score) {
                System.out.println(-1);
                return;
            }



            int score = 1;
            for (int i = 0; i < rank.length; i++) {
                if (new_score < rank[i])
                    score++;
            }
            System.out.print(score);
        } else {
                System.out.println(1);
                return;
        }
    }

}
