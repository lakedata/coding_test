package Level2;

import java.util.*;
public class 게임맵최단거리 { //문제 유형: 깊이/너비 우선 탐색(DFS/BFS)
    public static boolean[][] visited;
    public static int []dx = {1, -1, 0 , 0};
    public static int []dy = {0, 0, 1, -1};

    public int solution(int[][] maps) {
        int answer;
        int[][] visited = new int[maps.length][maps[0].length];
        bfs(maps, visited);
        answer = visited[maps.length - 1][maps[0].length - 1]; // 상대 팀 진영 좌표

        if(answer == 0)
            answer = -1;

        return answer;
    }

    public void bfs(int[][] maps, int[][] visited) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0}); // Queue에 시작 정점 추가
        visited[0][0] = 1;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int X = current[0];
            int Y = current[1];

            for(int i = 0; i < 4; i++) {
                int nX = X + dx[i];
                int nY = Y + dy[i];

                if (nX < 0 || nX > maps.length - 1 || nY < 0 || nY > maps[0].length - 1) {
                    continue;
                }
                if (visited[nX][nY] == 0 && maps[nX][nY] == 1) {
                    visited[nX][nY] = visited[X][Y] + 1; //거리 증가
                    q.add(new int[]{nX, nY});
                }
            }
        }
    }
}
