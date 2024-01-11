package PCCP.Lv3;

import java.util.LinkedList;
import java.util.Queue;

public class 보물지도 {
    private class Pos {
        int x, y, cnt, jump; //1 : 마법의 신발 보유, 0: 마법의 신발 미보유

        Pos(int x, int y, int cnt, int jump) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.jump = jump;
        }
    }
    private final int MAX_VAL = 987654321;
    private final int[][] dy = {{-1, 0, 1, 0}, {-2, 0, 2, 0}};
    private final int[][] dx = {{0, -1, 0, 1}, {0, -2, 0, 2}};
    private int[][] map;
    private boolean[][][] visit;

    public int solution(int n, int m, int[][] hole) {
        int answer = MAX_VAL;
        map = new int[n][m]; // n, m = x, y
        visit = new boolean[n][m][2];

        for(int[] h : hole) {
            map[h[0] - 1][h[1] - 1] = -1; // -1 : 함정
        }

        map[n - 1][m - 1] = 1; // 1: 보물

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, 0, 0, 1));

        while(!queue.isEmpty()) {
            Pos cur = queue.poll();

            if(visit[cur.x][cur.y][cur.jump]) {
                continue;
            }
            visit[cur.x][cur.y][cur.jump] = true;

            if(map[cur.x][cur.y] == 1) { //도착지점
                answer = Math.min(answer, cur.cnt); //최소값 갱신
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[0][i];
                int ny = cur.y + dy[0][i];

                if(0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] != -1) { //맵 존재, 함정X
                    queue.add(new Pos(nx, ny, cur.cnt + 1, cur.jump));
                }
            }

            if(cur.jump == 1) {
                for(int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[1][i];
                    int ny = cur.y + dy[1][i];

                    if(0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] != -1) { //맵 존재, 함정X
                        queue.add(new Pos(nx, ny, cur.cnt + 1, 0));
                    }
                }
            }
        }
        return answer == MAX_VAL ? -1 : answer;
    }

}
