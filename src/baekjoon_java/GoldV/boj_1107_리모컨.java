package baekjoon_java.GoldV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1107_리모컨 {  //문제유형: 브루트포스 , 메모리 제한: 256MB, 시간 제한: 2초s
    static boolean[] chk;
    static int ans, N, M;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //채널
        M = Integer.parseInt(br.readLine()); //고장난 버튼 수


        chk = new boolean[10]; // 고장난 버튼
        if (M > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int button = Integer.parseInt(st.nextToken());
                chk[button] = true;
            }
        }

        ans = Math.abs(N - 100); // 100부터 +, -를 이용해서 움직이는 경우

        dfs(); //버튼 누른 후 움직이는 경우
        System.out.println(ans);
    }

    public static void dfs() {
        for (int i = 0; i <= 1000000; i++) { //이동하려고 하는 채널이 0부터 50만(밑, 위 고려)
            String str = String.valueOf(i);
            int len = str.length();

            boolean up = false;
            for (int j = 0; j < len; j++) {
                if (chk[str.charAt(j) - '0']) { //고장난 번호가 리스트에 있는지 확인
                    up = true;
                    break;
                }
            }

            if (!up) {
                int min = Math.abs(N - i) + len; //(현재 탐색 중인 채널과 이동하려는 채널 차이) + 채널 길이
                ans = Math.min(min, ans);
            }
        }
    }
}
