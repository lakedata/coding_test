package baekjoon_java.BronzeI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 성지키기 { //1236번 구현
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int col_sum = 0;
        int row_sum = 0;

        boolean[][] arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {

                if (str.charAt(j) == '.') {
                    arr[i][j] = false;
                } else {
                    arr[i][j] = true;
                }
            }
        }

        // 열검사
        for (int i = 0; i < M; i++) {
            int count = 0;

            for (int k = 0; k < N; k++) {
                if (arr[k][i] == false) {
                    count++;
                }
            }

            if (count == N) {
                col_sum++; //열에 필요한 경비원 수
            }
        }

        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int k = 0; k < M; k++) {
                if (arr[i][k] == false) {
                    count++;
                }
            }

            if (count == M) {
                row_sum++;// 행에 필요한 경비원 수
            }
        }
        System.out.println(Math.max(row_sum, col_sum));// 행, 열 중 더 많은 경비원 추가
    }
}
