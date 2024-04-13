package baekjoon_java.SilverIV;

import java.io.*;

public class boj_1065_한수 { //문제유형: 브루트포스 , 메모리 제한: 128MB, 시간 제한: 2초
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int cnt = 0; // 한수 카운팅

        if (num < 100) {
            System.out.println(num);
        }
        else {
            cnt = 99;
            for (int i = 100; i <= num; i++) {
                int hun = i / 100; // 백의 자릿수
                int ten = (i / 10) % 10; // 십의 자릿수
                int one = i % 10;

                if ((hun - ten) == (ten - one)) { // 각 자릿수가 수열을 이루면
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
