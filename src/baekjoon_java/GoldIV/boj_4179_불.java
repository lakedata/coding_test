package baekjoon_java.GoldIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_4179_불 { // 유형: BFS, 메모리제한: 256MB, 시간 제한: 1초
    static int R, C, res;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] map;
    static Queue<Pair> fire = new LinkedList<>();
    static Queue<Pair> jh = new LinkedList<>();
    static class Pair {
        int x, y, d;

        public Pair(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public static void main(String argsp[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // 행
        C = Integer.parseInt(st.nextToken()); // 열
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String info = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = info.charAt(j);

                if (map[i][j] == 'F')
                    fire.add(new Pair(i, j, 0));
                else if (map[i][j] == 'J')
                    jh.add(new Pair(i, j, 0));

            }
        }
        if (bfs()) System.out.println(res);
        else System.out.println("IMPOSSIBLE");
    }

    public static boolean bfs() {
        while (!jh.isEmpty()) {
            // 불 전파 먼저
            int size = fire.size();

            for (int i = 0; i < size; i++) {
                Pair now = fire.poll();
                for (int d = 0; d < 4; d++) {
                    int dr = now.x + dx[d];
                    int dc = now.y + dy[d];

                    if (dr < 0 || dc < 0 || dr >= R || dc >= C) continue;
                    if (map[dr][dc] == '#' || map[dr][dc] == 'F') continue;

                    map[dr][dc] = 'F';
                    fire.add(new Pair(dr, dc, now.d + 1));
                }
            }

            // 지훈 이동
            size = jh.size();

            for (int i = 0; i < size; i++) {
                Pair now = jh.poll();
                for (int d = 0; d < 4; d++) {
                    int dr = now.x + dx[d];
                    int dc = now.y + dy[d];

                    if (dr < 0 || dc < 0 || dr >= R || dc >= C) {
                        res = now.d + 1;
                        return true;
                    }
                    if (map[dr][dc] == '#' || map[dr][dc] == 'F' || map[dr][dc] == 'J') continue;

                    map[dr][dc] = 'J';
                    jh.add(new Pair(dr, dc, now.d + 1));
                }
            }
        }
        return false;
    }
}
