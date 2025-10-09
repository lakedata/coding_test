import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] belt = new int[2 * N];
        boolean[] robot = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) belt[i] = Integer.parseInt(st.nextToken());

        int step = 0;

        while (true) {
            step++;

            // 1단계) 벨트 회전
            int last = belt[2 * N - 1];
            for (int i = 2 * N - 1; i >= 1; i--) belt[i] = belt[i - 1];
            belt[0] = last;

            // 로봇 회전
            for (int i = N - 1; i >= 1; i--) robot[i] = robot[i - 1];
            robot[0] = false;           // 올리는 위치에 회전 후 로봇 없음
            robot[N - 1] = false;      // 내리는 위치에 로봇 내림

            // 2단계) 로봇 이동
            for (int i = N - 1; i > 0; i--) {
                if (robot[i - 1] && !robot[i] && belt[i] > 0) {  // 올라가는 위치에 로봇이 없고, 내구도가 1이상이면 올리기
                    robot[i - 1] = false;
                    robot[i] = true;
                    belt[i]--;
                    robot[N - 1] = false;
                }
            }

            // 3단계) 올리는 위치에 로봇 올리기
            if (belt[0] > 0) {
                robot[0] = true;
                belt[0]--;
            }

            // 4단계) 내구도 0 칸 개수 검사
            int cnt = 0;
            for (int i = 0; i < 2 * N; i++) if (belt[i] == 0) cnt++;
            if (cnt >= K) {
                System.out.println(step);
                return;
            }
        }
    }
}
