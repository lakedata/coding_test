package baekjoon_java.BronzeII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10820_문자열분석 { //유형: 구현/문자열, 메모리제한: 256MB, 시간 제한: 1초
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        while ((str = br.readLine()) != null) {
            int small = 0, big = 0, num = 0, blank = 0;

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                if (c >= 'a' && c <= 'z') small++;
                else if (c >= 'A' && c <= 'Z') big++;
                else if (c >= '0' && c <= '9') num++;
                else if(c == ' ') blank++;
            }
            //소문자, 대문자, 숫자, 공백의 개수
            System.out.println(small + " " + big + " " + num + " " + blank);
        }
    }
}
