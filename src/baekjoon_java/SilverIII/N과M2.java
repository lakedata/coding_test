package baekjoon_java.SilverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M2 {
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    public static int N;

    public static int M;

    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visit = new boolean[N];

        back(0, 0);
        System.out.println(sb);
    }

    public static void back(int at, int depth) {//at현재 위치
        if (depth == M) {	// 재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열을 출력
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = at; i < N; i++) {
                arr[depth] = i + 1;//현재 깊이의 위치에 i값을 담는다
                back(i + 1, depth + 1);//재귀호출
            }
        }
}