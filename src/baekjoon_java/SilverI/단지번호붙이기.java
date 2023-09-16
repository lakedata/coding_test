package baekjoon_java.SilverI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class 단지번호붙이기 {
    static int N, cnt = 0;//총 단지수, 단지내 집의 수
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};;//상하좌우(좌우)
    static int[] dy = {-1,1,0,0};//상하좌우(상하)

    public static ArrayList<Integer> cnts = new ArrayList<>();


    public static void main(String[] arg) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int x = 0; x < N; x++) {
            String s = br.readLine();
            for (int y = 0; y < N; y++) {
                map[x][y] = s.charAt(y) - '0';//숫자형태의 String 에서 int 변수로 바로 변환
                //System.out.println(map[x][y]);
            }
        }

        cnt = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if(map[x][y] == 1 && !visited[x][y]){
                    cnt=1;
                    dfs(x,y);
                    cnts.add(cnt);
                }
            }
        }
        System.out.println(cnts.size());
        Collections.sort(cnts);

        for(int i = 0; i < cnts.size(); i++) {
            System.out.println(cnts.get(i));
        }

    }
        public static int dfs ( int x, int y) {
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {//좌표  범위
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        dfs(nx, ny);
                        cnt++;
                    }
                }
            }
            //System.out.println(cnt);
            return cnt;
        }
}
