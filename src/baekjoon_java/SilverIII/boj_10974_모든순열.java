package baekjoon_java.SilverIII;

import java.io.*;

public class boj_10974_모든순열 { //유형: 브루트포스, 백트래킹
    static int N;
    static int[] res, arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        res = new int[N];
        visited = new boolean[N ];

        perm(0);
        System.out.println(sb);
    }

    static void perm(int depth) {
        if (depth == N) {
            for (int i : res) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                res[depth] = i + 1;
                perm(depth + 1);
                visited[i] = false;
            }
        }
    }
}
