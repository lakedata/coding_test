package baekjoon_java.BronzeI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bog_1157_단어공부 {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String str = input.toUpperCase();

        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - 'A';
            count[num]++;
        }

        /*단어 최댓값 체크*/
        //문자열에 저장된 알파벳 개수의 최댓값을 저장 할 변수
        int max = 0;
        //최댓값을 가지는 알파벳을 저장
        char Cmax = '?';

        for (int i = 0; i < count.length; i++) {
            if (max == count[i]) {
                Cmax = '?';
            }

            if (max < count[i]) {
                max = count[i];
                Cmax = (char) (i + 'A');
            }
        }
        System.out.println(Cmax);
    }
}
