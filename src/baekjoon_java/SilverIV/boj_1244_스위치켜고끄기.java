package baekjoon_java.SilverIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1244_스위치켜고끄기 {
    static int num; // 스위치 개수
    static int[] state; // 스위치 상태

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        state = new int[num + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= num; i++) {
            state[i] = Integer.parseInt(st.nextToken());
        }

        int student = Integer.parseInt(br.readLine()); // 학생 수
        for (int i = 1; i <= student; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (gender == 1) //남자
                man(n);
            else if (gender == 2) //여자
                woman(n);
        }

        for (int i = 1; i <= num; i++) {
            System.out.print(state[i] + " ");
            if (i % 20 == 0)
                System.out.println();
        }

    }

    static void man(int n) {
        for (int i = n; i <= state.length - 1; i += n) {
            if (i % n == 0) { // 스위치 번호가 자기가 받은 수의 배수이면
                state[i] = (state[i] == 1) ? 0 : 1;
            }
        }
    }

    static void woman(int n) {
        state[n] = state[n] == 0 ? 1 : 0;

        int cnt = 1;
        while (n - cnt >= 1 && n + cnt <= state.length - 1) {
            if (state[n - cnt] == state[n + cnt]) { // 같으면
                state[n - cnt] = state[n - cnt] == 0 ? 1 : 0;
                state[n + cnt] = state[n + cnt] == 0 ? 1 : 0;
            } else {
                break;
            }
            cnt++;
        }
    }
}
