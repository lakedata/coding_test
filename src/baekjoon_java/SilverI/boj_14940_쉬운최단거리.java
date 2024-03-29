package baekjoon_java.SilverI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14940_쉬운최단거리 { //유형 : BFS(너비 우선 탐색) , 메모리 제한:128 MB , 시간 제한: 1초
    static int n, m;
    static int[][] arr;
    static int[][] result;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        result = new int[n][m];
        Point start = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                // 0: 갈 수 없는 땅, 1: 갈 수 있는 땅, 2: 목표지점
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) { //목표지점 시작 좌표로 설정
                    start = new Point(i, j);
                }
            }
        }

        bfs(start);
        printResult();
    }

    public static void bfs(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int px = point.x;
            int py = point.y;

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 1 && result[nx][ny] == 0) {
                    queue.add(new Point(nx, ny));
                    result[nx][ny] = result[px][py] + 1;
                }
            }
        }
    }

    public static void printResult() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (result[i][j] == 0 && arr[i][j] == 1) {
                    System.out.print("-1 ");
                } else {
                    System.out.print(result[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
