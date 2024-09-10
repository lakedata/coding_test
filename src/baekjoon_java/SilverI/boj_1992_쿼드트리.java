package baekjoon_java.SilverI;

import java.io.*;
import java.util.*;

public class boj_1992_쿼드트리 {
    static int [][]arr;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();

            for(int j = 0; j < N; j++)
                arr[i][j] = str.charAt(j) - '0';
        }

        QuadTree(0, 0, N);
        System.out.println(sb);

    }
    public static void QuadTree(int x, int y, int size) {

        if(isCheck(x, y, size)) {
            sb.append(arr[x][y]);
            return;
        }

        int newSize = size / 2;

        sb.append('('); // 각 레벨(depth)에서 여는 괄호

        QuadTree(x, y, newSize); // 2사분면 - 왼쪽 위
        QuadTree(x, y + newSize, newSize); //1사분면 - 오른쪽 위
        QuadTree(x + newSize, y, newSize); // 3사분면 - 왼쪽 아래
        QuadTree(x + newSize, y + newSize, newSize); //4사분면 - 오른족 아래

        sb.append(')'); //레벨 끝나면 닫는 괄호
    }
    public static boolean isCheck(int x, int y, int size) {
        int value = arr[x][y]; // 첫 번째 원소를 기준으로 검사

        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if (value != arr[i][j])
                    return false;
            }
        }
        return true;
    }
}
