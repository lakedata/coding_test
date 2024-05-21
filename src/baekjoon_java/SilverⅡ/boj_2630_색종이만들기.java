package baekjoon_java.SilverⅡ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2630_색종이만들기 { // 유형: 분활정복, 재귀
    public static int white = 0;
    public static int blue = 0;
    public static int[][] board;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) { // 0: 흰색, 1 : 파란
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        partition(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void partition(int row, int col, int size) {
        if (colorCheck(row, col, size)) {
            if (board[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }
        int newSize = size / 2;    // 절반 사이즈
        // 재귀 호출
        partition(row, col, newSize);                        // 2사분면
        partition(row, col + newSize, newSize);                // 1사분면
        partition(row + newSize, col, newSize);                // 3사분면
        partition(row + newSize, col + newSize, newSize);    // 4사분면
    }

    public static boolean colorCheck(int row, int col, int size) {
        int color = board[row][col]; //첫번째 원소 기준으로 검사

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
