package baekjoon_java.SilverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스 {
    static int node, line;//개수, 쌍
    static int cnt = 0;
    static int[][] arr;//인접행렬
    static boolean[] check;//감영여부

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        arr = new int[node + 1][node + 1];
        check = new boolean[node + 1];

        for (int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }
        dfs(1);

        System.out.println(cnt - 1);
    }

    public static void dfs(int start) {
        check[start] = true;
        cnt++;

        for (int i = 0; i <= node; i++) {
            if (arr[start][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }
}
