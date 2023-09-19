package baekjoon_java.SilverⅡ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연결요소의개수 {
    static int N, M;//정점, 간선, 시작번호
    static int[][] arr;//인접행렬
    static boolean[] visited;

    public static void main(String[] arg) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        int result = 0; // 구역 수
        visited = new boolean[N + 1];
        for (int node = 1; node < arr.length; node++) {
            if (!visited[node]) {
                dfs(node);
                result++;
            }
        }
        System.out.println(result);
    }


    public static void dfs(int V) {
        visited[V] = true;

        for (int node = 1; node < arr.length; node++) {
            if (arr[V][node] == 1 && !visited[node]) {
                dfs(node);
            }
        }
    }
}

