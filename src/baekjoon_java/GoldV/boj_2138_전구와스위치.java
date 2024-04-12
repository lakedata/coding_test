package baekjoon_java.GoldV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2138_전구와스위치 {  //문제유형: 그리디 , 메모리 제한: 128MB, 시간 제한: 2초
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s1 = br.readLine(); //현재 상태
        String s2 = br.readLine(); //원하는 상태

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = s1.charAt(i) - '0'; // a는 0번 스위치를 안누른 경우
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = s2.charAt(i) - '0';

        int[] c = Arrays.copyOf(a, n); // c는 0번째 스위치를 누른 경우
        c[0] = 1 - c[0]; // 0번째 스위치를 누르지 않은 경우
        c[1] = 1 - c[1]; //0번째 스위치를 누른 경우

        int answer = solve(n, a, b);
        int answer2 = solve(n, c, b);
        if (answer2 != -1) answer2++;

        if (answer == -1)
            System.out.println(answer2);
        else if (answer2 == -1)
            System.out.println(answer);
        else
            System.out.println(Math.min(answer2, answer));
    }

    static int solve(int n, int[] a, int[] b) {
        int cnt = 0;

        for (int i = 0; i < n - 1; i++) {
            if (a[i] != b[i]) {
                cnt++;
                a[i] = 1 - a[i];
                a[i + 1] = 1 - a[i + 1];
                if (i != n - 2)
                    a[i + 2] = 1 - a[i + 2];
            }
        }
        return a[n - 1] != b[n - 1] ? -1 : cnt;
    }
}
