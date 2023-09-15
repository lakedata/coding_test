package baekjoon_java.SilverⅡ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS {
    static int N, M, V;//정점, 간선, 시작번호
    static int[][] arr;//인접행렬
    static boolean[] visited;

    public static void main(String[] arg) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);
        System.out.println();
    }

    public static void dfs(int V) {
        visited[V] = true;
        System.out.print(V + " ");

        for (int node = 1; node < arr.length; node++) {
            if (arr[V][node] == 1 && !visited[node]) {
                dfs(node);
            }
        }
    }

    public static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(V); // 큐에 해당 정점 번호를 넣어줌
        visited[V] = true; // 방문했다는 표식을 남겨줌

        System.out.print(V + " ");
        while (!queue.isEmpty()) { // 큐가 비어있지 않으면
            int temp = queue.poll(); // 큐에 담겨있는 번호 중 가장 앞에 담겨져있는 번호
            for (int node = 1; node < arr.length; node++) {
                if (arr[temp][node] == 1 && visited[node] == false) { // 해당 노드와 연결된 다른 노드가 있고 그 다른 노드를 아직 방문하지 않았다면
                    queue.add(node); // 다른 노드를 queue에 넣고
                    visited[node] = true; // 방문했다는 표식을 남겨줌
                    System.out.print(node + " ");
                }
            }
        }
    }
}
