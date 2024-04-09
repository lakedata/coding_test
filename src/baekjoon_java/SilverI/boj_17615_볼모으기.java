package baekjoon_java.SilverI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_17615_볼모으기 { //문제유형: 그리디, 메모리 제한: 512MB, 시간 제한: 1초
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        str.toCharArray();

        int rCnt = 0, bCnt = 0;
        int BallCnt = 0;
        int move = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            if (str.charAt(i) == 'R') rCnt++;
            else bCnt++;
        }

        //1. 'R'을 맨 맨 앞으로 모으는 경우
        for (int i = 0; i < N; i++) {
            if (str.charAt(i) == 'R') BallCnt += 1;
            else break;
        }
        move = Math.min(move, rCnt - BallCnt);

        //2. 'R'을 맨 뒤로 모으는 경우
        BallCnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (str.charAt(i) == 'R') BallCnt += 1;
            else break;
        }
        move = Math.min(move, rCnt - BallCnt);

        //3. 'B'을 맨 맨 앞으로 모으는 경우
        BallCnt = 0;
        for (int i = 0; i < N; i++) {
            if (str.charAt(i) == 'B') BallCnt += 1;
            else break;
        }
        move = Math.min(move, bCnt - BallCnt);

        //4. 'B'을 맨 뒤로 모으는 경우
        BallCnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (str.charAt(i) == 'B') BallCnt += 1;
            else break;
        }
        move = Math.min(move, bCnt - BallCnt);

        System.out.println(move);
    }
}
