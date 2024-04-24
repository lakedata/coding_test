package baekjoon_java.GoldIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_4485_녹색옷입은애가젤다지 { //유형: 최단경로 , 메모리제한: 256 MB, 시간 제한: 1초
    static class Node implements Comparable<Node> {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) { // 도둑루피 크기 비교
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int N;
    static int dx[] = {0, 0, -1, 1}; // 상하좌우
    static int dy[] = {-1, 1, 0, 0};
    static int map[][];
    static int[][] move;
    static Queue<Node> queue;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int idx = 1;
        while (true) {
            N = Integer.parseInt(br.readLine()); //동굴 크기

            if (N == 0) {
                break;
            }

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("Problem " + idx + ": " + bfs()+"\n");
            idx++;
        }
        System.out.println(sb.toString());
    }

    static int bfs() {
        queue = new PriorityQueue<>();
        move = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(move[i], Integer.MAX_VALUE);
        }

        queue.add(new Node(0, 0, map[0][0])); //(0,0) 부터 탐색
        move[0][0] = map[0][0];

        while (!queue.isEmpty()) {
            Node pos = queue.poll();

            int px = pos.x, py = pos.y;
            int cost = pos.cost;

            if (px == N - 1 && py == N - 1) {
                return cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1) continue;

                if (cost + map[ny][nx] < move[ny][nx]) { // 새로운 경로 cost < 기존 저장 cost
                    move[ny][nx] = cost + map[ny][nx];
                    queue.add(new Node(nx, ny, cost + map[ny][nx]));
                }
            }
        }
        return -1;
    }
}
