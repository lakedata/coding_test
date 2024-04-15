package baekjoon_java.GoldIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16236_아기상어 { // 문제유형: 너비 우선 탐색(BFS), 메모리 제한: 512 MB, 시간 제한: 2초
    static int N, sharkRow, sharkCol, sharkSize = 2, eatCnt = 0;
    static int answer = 0; // 결과값
    static int map[][];
    static int[] dx = {0, 0, -1, 1}; // 상 하 좌 우
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;
    static Queue<Node> queue;

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) { // 상어인 경우
                    sharkRow = i;
                    sharkCol = j;
                    map[i][j] = 0;
                }
            }
        }
        while (true) {
            if (!BFS()) break;
        }
        System.out.println(answer);
    }

    private static boolean BFS() {
        visited = new boolean[N][N];
        queue = new LinkedList<>();

        queue.add(new Node(sharkRow, sharkCol, 0));
        visited[sharkRow][sharkCol] = true;
        int minDistance = Integer.MAX_VALUE;
        int minX = N, minY = N;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.distance > minDistance) break; // 더 이상 탐색할 필요 없음

            for (int i = 0; i < 4; i++) { // 상하좌우 방향
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int dis = node.distance + 1;

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] <= sharkSize) {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny, dis));

                    // 물고기를 찾은 경우
                    if (map[nx][ny] > 0 && map[nx][ny] < sharkSize) {
                        if (dis < minDistance) {
                            minDistance = dis;
                            minX = nx;
                            minY = ny;
                        } else if (dis == minDistance) {
                            if (nx < minX || (nx == minX && ny < minY)) {
                                minX = nx;
                                minY = ny;
                            }
                        }
                    }
                }
            }
        }

        if (minX != N && minY != N) { // 먹을 수 있는 물고기가 있는 경우
            map[minX][minY] = 0; // 물고기 먹기
            sharkRow = minX;
            sharkCol = minY;
            eatCnt++;

            if (eatCnt == sharkSize) { // 상어 크기 증가
                sharkSize++;
                eatCnt = 0;
            }

            answer += minDistance;
            return true;
        }

        return false; // 더 이상 먹을 물고기가 없는 경우
    }

    public static class Node {
        int x, y, distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
