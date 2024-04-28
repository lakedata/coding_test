package baekjoon_java.BronzeII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2675_문자열반복 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder("");

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();

            int key = 0;
            while (key < S.length()) {
                for (int j = 0; j < R; j++) {
                    sb.append(S.charAt(key));
                }
                key++;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
