package baekjoon_java.GoldV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_12919_A와B2 { //유형: 문자열,브루트포스,재귀 , 메모리 제한: 512MB, 시간 제한: 2초
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        int result = Possible(S, T);
        System.out.println(result);
    }

    public static int Possible(String S, String T) {
        if (S.length() == T.length()) {
            if (S.equals(T))
                return 1;
            return 0;
        }

        int ans = 0;
        if (T.charAt(T.length() - 1) == 'A') {
            ans += Possible(S, T.substring(0, T.length() - 1));
        }

        if (T.charAt(0) == 'B') { // 맨 앞이 B라면 B를 빼고 뒤집은것만 다시 탐색.
            String substring = T.substring(1);
            StringBuilder sb = new StringBuilder(substring);
            ans += Possible(S, sb.reverse().toString());
        }
        return ans > 0 ? 1 : 0;
    }
}
