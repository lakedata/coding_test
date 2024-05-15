package baekjoon_java.GoldIII;

import java.io.*;
import java.util.*;

public class boj_1238_파티 { //다익스트라(Dijkstra)
    static int N, M, X;
    private static List<List<Node>> list, reverseList;
    private static int[] dist1, dist2;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 학생 수(정점)
        M = Integer.parseInt(st.nextToken()); // 단방향 도로(간선)
        X = Integer.parseInt(st.nextToken()); // 이동 시간

        list = new ArrayList<>();
        reverseList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()); // 출발 노드
            int end = Integer.parseInt(st.nextToken()); // 도착 노드
            int weight = Integer.parseInt(st.nextToken()); // 가중치

            list.get(start).add(new Node(end, weight));
            reverseList.get(end).add(new Node(start, weight));
        }

        dist1 = Dijkstra(list, X); //정방향 (모든 노드 -> X)
        dist2 = Dijkstra(reverseList, X); //역방향 (X -> 모든 노드)

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++)
            max = Math.max(max, dist1[i] + dist2[i]);
        System.out.println(max);
    }

    static public int[] Dijkstra(List<List<Node>> list, int X) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[X] = 0;
        pq.add(new Node(X, 0)); // X에서 시작

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cur = node.end;

            if (visited[node.end]) continue;
            visited[cur] = true;

            for (int i = 0; i < list.get(node.end).size(); i++) {
                int next = list.get(cur).get(i).end;
                int weight = list.get(cur).get(i).weight;


                if (dist[next] > dist[cur] + weight) {
                    dist[next] = dist[cur] + weight;
                    pq.add(new Node(next, dist[next]));
                }
            }
        }
        return dist;
    }

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight; //weight 오름차순
        }
    }
}
