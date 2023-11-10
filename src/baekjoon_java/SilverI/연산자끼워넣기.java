package baekjoon_java.SilverI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
https://www.acmicpc.net/problem/14888
15580KB 136ms 백트래킹
 */
public class 연산자끼워넣기 {
    public static int MAX = Integer.MIN_VALUE;    // 최댓값
    public static int MIN = Integer.MAX_VALUE;    // 최솟값
    public static int[] operator = new int[4];    // 연산자 개수 +, -, *, /
    public static int[] number;                    // 숫자
    public static int N;                        // 숫자 개수


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        number = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            number[i] = Integer.parseInt(st.nextToken());

        // 연산자 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++)
            operator[i] = Integer.parseInt(st.nextToken());

        dfs(number[0], 1); //탐색
        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int num, int idx) { // 백트래킹으로 최대, 최소값 탐색
        if (idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) { //해당 연산자의 남은 갯수가 없으면 pass
                operator[i]--; // 연산자 1개 소모
                switch (i) {
                    case 0:
                        dfs(num + number[idx], idx + 1); break;
                    case 1:
                        dfs(num - number[idx], idx + 1); break;
                    case 2:
                        dfs(num * number[idx], idx + 1); break;
                    case 3:
                        dfs(num / number[idx], idx + 1); break;
                }
                operator[i]++; // 소모한 연산자 1개 다시 회복
            }
        }
    }
}
