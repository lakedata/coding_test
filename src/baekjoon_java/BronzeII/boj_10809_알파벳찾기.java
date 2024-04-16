package baekjoon_java.BronzeII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_10809_알파벳찾기 { //문제유형: 구현, 문자열 , 메모리 제한: 256MB, 시간 제한: 1초

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] alpha = new int[26];

        Arrays.fill(alpha, -1);

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';

            if(alpha[index] == -1)
                alpha[index] = i;
        }

        for (int i = 0; i < alpha.length; i++) {
            System.out.print(alpha[i] + " ");
        }
    }
}
