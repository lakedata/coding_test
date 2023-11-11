package baekjoon_java.SilverI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와링크 {
    public static int N;
    static int[][] map;
    static boolean[] visit;
    public static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0); //탐색
        System.out.println(Min);
    }

    //  num은 조합 개수(=재귀 깊이), idx는 인덱스
    public static void dfs(int num, int idx) {
        if (num == N / 2) {
            /*
            팀원 수가 반반이 되면 방문한 팀과 방문하지 않은 팀을 각각 나누어
			 각 팀의 점수를 구한 뒤 최솟값을 찾는다.
			*/
            diff();
            return;
        }

        /*visited[]를 통해 재귀적으로 팀 순서쌍을 만들어준다.
        1,2 = 2,1 이기 때문에 반복문을 index부터 시작해서 돌려준다.
        isited[]가 같은 값인 것들이 한 팀을 이룬다.*/
        for (int i = idx; i < N; i++) {
            // 방문하지 않았다면?
            if (!visit[i]) {
                visit[i] = true;    // 방문으로 변경
                dfs(num + 1, i + 1);    // 재귀 호출
                visit[i] = false;    // 재귀가 끝나면 비방문으로 변경
            }
        }
    }

    // 두 팀의 능력치 차이를 계산하는 함수
    public static void diff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < N - 1; i++) { // 두 사람을 선택해 능력치를 계산
            for (int j = i + 1; j < N; j++) { // 조합이므로 앞선 사람의 다음 사람부터 탐색
                if (visit[i] == true && visit[j] == true) {
                    start += map[i][j];
                    start += map[j][i];
                } else if (visit[i] == false && visit[j] == false) {
                    link += map[i][j];
                    link += map[j][i];
                }

            }
        }

        int val = Math.abs(start - link); // 두 팀의 점수 차이 (절댓값)

        /*
         * 두 팀의 점수차가 0이라면 가장 낮은 최솟값이기 때문에
         * 더이상의 탐색 필요없이 0을 출력하고 종료하면 된다.
         */
        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        Min = Math.min(val, Min);
    }
}
