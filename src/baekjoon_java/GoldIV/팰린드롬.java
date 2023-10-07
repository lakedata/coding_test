package baekjoon_java.GoldIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팰린드롬 {//팰린드롬? 10942번
    static int N;
    static int[] arr;
    static boolean check[][];


    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        check = new boolean[N + 1][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();

        int M = Integer.parseInt(br.readLine());

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if (check[S][E]) {
                sb.append(1 + "\n");
            } else {
                sb.append(0 + "\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void solve() {
        for (int i = 1; i <= N; i++) {
            check[i][i] = true;
        }
        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i + 1]) check[i][i + 1] = true;
        }
        for (int i = 2; i < N; i++) {
            for (int k = 1; k <= N - i; k++) {
                if (arr[k] == arr[k + i] && check[k + 1][k + i - 1]) {
                    check[k][k + i] = true;
                }
            }
        }
    }
}
