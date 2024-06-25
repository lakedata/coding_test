package Level3;

public class 네트워크 { //문제유형: 깊이/너비 우선 탐색(DFS/BFS)
    static boolean[] visited;
    static int count = 0;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }

    static void dfs(int V, int[][] computers) {
        visited[V] = true;

        for (int node = 0; node < computers.length; node++) {
            if (computers[V][node] == 1 && !visited[node])
                dfs(node, computers);
        }
    }
}
