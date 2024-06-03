package baekjoon_java.GoldIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2206_벽부수고이동하기 { // 문제유형: 너비 우선 탐색(BFS), 메모리 제한: 192 MB, 시간 제한: 2초
    static int N, M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][][] visit;

    static class Node {
        int x, y, dist, wall;

        Node(int x, int y, int dist, int wall) {
            this.x = x;
            this.y = y;
            this.dist = dist; //이동 거리
            this.wall = wall; //벽 부순 여부
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    public static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 1, 0)); //시작 지점
        visit[x][y][0] = true; // 벽을 부수지 않은 상태로 시작

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == N - 1 && node.y == M - 1) {
                return node.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0 && !visit[nx][ny][node.wall]) { //지나갈 수 있는 길이면?
                        visit[nx][ny][node.wall] = true;
                        queue.add(new Node(nx, ny, node.dist + 1, node.wall)); //벽 안 부수고 거리 추가
                    } else if (map[nx][ny] == 1 && node.wall == 0 && !visit[nx][ny][1]) { // 벽이 있고, 아직 벽을 부수지 않은 상태인 경우
                        visit[nx][ny][1] = true; // 벽을 부쉈다고 표시
                        queue.add(new Node(nx, ny, node.dist + 1, 1));
                    }
                }
            }
        }
        return -1;
    }
}
