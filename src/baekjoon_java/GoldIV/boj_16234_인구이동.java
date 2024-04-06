package baekjoon_java.GoldIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16234_인구이동 { //유형: DFS, 메모리제한: 512 MB, 시간 제한: 2초
    static int N, L, R;
    static int cnt; //연합 국가 개수
    static int sum;
    static int map[][] = new int[50][50];
    static int visited[][] = new int[50][50];

    public static void main(String args[]) throws IOException { //문제유형:그래프탐색
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve());
    }

    static void move(int r, int c, int value) {
        if (r < 0 || r > N - 1 || c < 0 || c > N - 1) return;
        if (visited[r][c] != 1) return;

        visited[r][c] = 2; // 0: 방문X , 1:연합 국가 ,2:최종적으로 인구 값 변경

        map[r][c] = value;
        move(r - 1, c, value);
        move(r + 1, c, value);
        move(r, c - 1, value);
        move(r, c + 1, value);
    }

    static int find(int r, int c, int value) { //DFS
        if (r < 0 || r > N - 1 || c < 0 || c > N - 1) return 0;
        if (visited[r][c] != 0) return 0;

        if (value != -1) { //최초 -1이라서 아닌 경우만
            int diff = Math.abs(value - map[r][c]); //음수일 경우 고려해서 절댓값
            if (diff < L || diff > R) return 0;
        }

        visited[r][c] = 1;
        ++cnt;

        sum = map[r][c];
        sum += find(r - 1, c, map[r][c]); //상
        sum += find(r + 1, c, map[r][c]); //하
        sum += find(r, c - 1, map[r][c]); //좌
        sum += find(r, c + 1, map[r][c]); //우

        return sum;
    }

    static int solve() {
        int ret = 0; //인구인동 횟수
        boolean flag;

        do {
            flag = false;

            for (int i = 0; i < N; ++i) { // 방문 초기화
                for (int j = 0; j < N; ++j) {
                    visited[i][j] = 0;
                }
            }

            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (visited[i][j] == 0) //방문한 적이 없다면
                    {
                        cnt = 0;
                        find(i, j, -1); //연합 국가의 총 인구 수
                        if (cnt > 1) {
                            flag = true;
                            move(i, j, sum / cnt);
                        } else  {
                            visited[i][j] = 2;
                        }
                    }
                }
            }
            if (flag) ++ret;
        } while (flag);

        return ret;
    }
}
