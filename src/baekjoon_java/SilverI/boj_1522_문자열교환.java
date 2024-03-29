package baekjoon_java.SilverI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1522_문자열교환 { //유형: 브루트포스 알고리즘/슬라이딩 윈도우, 메모리 제한: 128 MB, 시간제한: 2초
    public static void main(String argsp[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int min = Integer.MAX_VALUE;
        int aCnt = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'a') aCnt++;
        }

        for(int i = 0; i < str.length(); i++) {
            int bCnt = 0;
            for(int j = i; j < i + aCnt; j++) {
                if(str.charAt(j % str.length()) == 'b')
                    bCnt++;
            }
            min = Math.min(min, bCnt);
        }

        System.out.println(min);
    }
}
