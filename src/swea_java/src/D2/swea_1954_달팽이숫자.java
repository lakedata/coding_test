package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1954_달팽이숫자 {
    static int[] dr = {0, 1, 0, -1}; // 우하좌상 순서
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];

            int dir = 0; //현방향 인덱스
            int r = 0, c = 0; //시작 좌표

            for (int i = 1; i <= N * N; i++) {
                arr[r][c] = i;
                if (r + dr[dir] >= N || r + dr[dir] < 0 || c + dc[dir] >= N || c + dc[dir] < 0
                        || arr[r + dr[dir]][c + dc[dir]] != 0) {

                    dir = (dir + 1) % 4;//방향전환
                }
                r += dr[dir];
                c += dc[dir];
            }

            // 출력
            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                for (int n : arr[i])
                    System.out.print(n + " ");
                System.out.println();
            }
        }
    }

}
