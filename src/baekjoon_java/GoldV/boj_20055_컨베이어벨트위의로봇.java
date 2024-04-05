package baekjoon_java.GoldV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20055_컨베이어벨트위의로봇 { //유형:구현, 시뮬레이션 , 메모리 제한: 512KB, 시간 제한: 1초
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] belt = new int[1001];
        boolean[] robot = new boolean[N];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int step = 0;

        while (true) {
            step++;

            // 1단계
            int tmp = belt[N * 2 - 1];  // 컨베이너 벨트 이동
            for (int i = N * 2 - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = tmp;

            for (int i = N - 1; i > 0; i--) {// 로봇이동
                robot[i] = robot[i - 1];
            }

            robot[0] = false; // N에서 로봇이 내리기 때문에 이동 후에는 0에 로봇이 없음
            robot[N - 1] = false;// 로봇 내리기

            // 2단계
            for (int i = N - 1; i > 0; i--) { // 로봇 이동
                if (robot[i - 1] && !robot[i] && belt[i] > 0) {  // 올라가는 위치에 로봇이 없고, 내구도가 1이상이면 올리기
                    robot[i - 1] = false;
                    robot[i] = true;
                    belt[i]--;
                    robot[N - 1] = false;
                }
            }

            // 3단계
            if (belt[0] > 0) {
                robot[0] = true;
                belt[0]--;
            }

            // 4단계
            int cnt = 0;
            for (int i = 0; i < N * 2; i++) {
                if (belt[i] == 0) cnt++;
            }
            if (cnt >= K) break;
        }

        System.out.println(step);
    }
}
