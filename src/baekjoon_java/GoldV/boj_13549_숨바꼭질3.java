package baekjoon_java.GoldV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13549_숨바꼭질3 { //BFS(너비우선탐색)/최단경로, 메모리 제한:512MB, 시간 제한: 2초
    static int min = Integer.MAX_VALUE;
    static int N, K;
    static boolean[] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //수빈 위치
        K = Integer.parseInt(st.nextToken()); //동생 위치

        visited = new boolean[100001];
        bfs();
        System.out.println(min);

    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(N, 0));
        visited[N] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == K)
                min = Math.min(min, node.time);

            if (node.x * 2 <= 100000 && !visited[node.x * 2]) {
                queue.offer(new Node(node.x * 2, node.time));
                visited[node.x * 2] = true;
            }

            if (node.x - 1 >= 0 && !visited[node.x - 1]) {
                queue.offer(new Node(node.x - 1, node.time + 1));
                visited[node.x - 1] = true;
            }

            if (node.x + 1 <= 100000 && !visited[node.x + 1]) {
                queue.offer(new Node(node.x + 1, node.time + 1));
                visited[node.x + 1] = true;
            }
        }
    }

    public static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
