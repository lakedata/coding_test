package baekjoon_java.GoldV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_20437_문자열게임2 { //유형: 문자열/슬라이딩 윈도우, 메모리 제한: 1024MB, 시간제한: 1초
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if(K == 1) {
                System.out.println("1 1");
                continue;
            }

            int[] alpha = new int[26]; //알파벳 개수
            for (int j = 0; j < W.length(); j++) {
                alpha[W.charAt(j) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = -1;
            for (int j = 0; j < W.length(); j++) {
                if (alpha[W.charAt(j) - 'a'] < K) continue;

                int count = 1;
                for (int l = j + 1; l < W.length(); l++) {
                    if (W.charAt(j) == W.charAt(l)) count++;
                    if (count == K) {
                        min = Math.min(min, l - j + 1);
                        max = Math.max(max, l - j + 1);
                        break;
                    }
                }
            }
            if (min == Integer.MAX_VALUE || max == -1) System.out.println("-1");
            else System.out.println(min + " " + max);
        }
    }
}
