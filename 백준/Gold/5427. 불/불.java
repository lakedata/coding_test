import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        StringTokenizer st;

        for (int T = 0; T < t; T++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); // 너비
            int h = Integer.parseInt(st.nextToken()); // 높이

            Character[][] build = new Character[h][w];
            boolean[][] vis = new boolean[h][w];
            Queue<Pair> fireQueue = new LinkedList<>();
            Queue<Pair> personQueue = new LinkedList<>();
            int startX = 0, startY = 0;

            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    build[i][j] = str.charAt(j);

                    if (build[i][j] == '@') {
                        startX = i;
                        startY = j;
                        personQueue.add(new Pair(i, j));
                        vis[i][j] = true;
                    } else if (build[i][j] == '*') {
                        fireQueue.add(new Pair(i, j));
                    }
                }
            }

            int time = 0;
            boolean escaped = false;

            while (!personQueue.isEmpty() && !escaped) {
                time++;

                // 1. 불의 번짐 처리
                int fireSize = fireQueue.size();
                for (int i = 0; i < fireSize; i++) {
                    Pair fire = fireQueue.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = fire.x + dx[dir];
                        int ny = fire.y + dy[dir];
                        if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                        if (build[nx][ny] == '.') {
                            build[nx][ny] = '*';
                            fireQueue.add(new Pair(nx, ny));
                        }
                    }
                }

                // 2. 사람의 이동 처리
                int personSize = personQueue.size();
                for (int i = 0; i < personSize; i++) {
                    Pair person = personQueue.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = person.x + dx[dir];
                        int ny = person.y + dy[dir];

                        // 탈출 조건
                        if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                            escaped = true;
                            break;
                        }

                        if (!vis[nx][ny] && build[nx][ny] == '.') {
                            vis[nx][ny] = true;
                            personQueue.add(new Pair(nx, ny));
                        }
                    }
                    if (escaped) break;
                }
            }

            if (escaped)
                System.out.println(time);
            else
                System.out.println("IMPOSSIBLE");
        }
    }
}
