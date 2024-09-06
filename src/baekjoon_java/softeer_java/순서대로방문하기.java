package baekjoon_java.softeer_java;
import java.io.*;
import java.util.*;

class Point {
    int x,y;

    public Point() {}

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }
}

public class 순서대로방문하기 { //[HSAT 7회 정기 코딩 인증평가]
    static int n, m, count = 0;
    static int []dx = {0, 0, -1, 1};
    static int []dy = {1, -1, 0, 0};
    static int [][]grid;
    static boolean[][] visit;
    public static Point[] dest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        visit = new boolean[n][n];
        dest = new Point[m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // for (int i = 0; i < n; i++) {
        //      grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //  }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            dest[i] = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        }

        dfs(dest[0], 1); // 모든 경우의 수 탐색

        System.out.println(count);
    }

    public static void dfs(Point cur, int index) {

        if(cur.equals(dest[index])) { //마지막 지점
            if(index == m - 1) {
                count++;
                return;
            }
            index++;
        }
        int curX = cur.x;
        int curY = cur.y;
        visit[curX][curY] = true;

        for(int dir = 0; dir < 4; dir++) {
            int nx = curX + dx[dir];
            int ny = curY + dy[dir];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(grid[nx][ny] == 1 || visit[nx][ny]) continue;

            visit[nx][ny] = true;
            dfs(new Point(nx, ny), index); // 다음 지점으로 이동
            visit[nx][ny] = false;
        }
    }
}
