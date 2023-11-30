package baekjoon_java.GoldIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11054_가장긴바이토닉부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        int S[] = new int[n];
        int up[] = new int[n];
        int down[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        // 상승
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (S[j] < S[i]) {
                    max = Math.max(max, up[j]);
                }
            }
            up[i] = max + 1;
        }
        // 하강
        for (int i = n - 1; i >= 0; i--) {
            int max = 0;
            for (int j = n - 1; j > i; j--) {
                if (S[j] < S[i]) {
                    max = Math.max(max, down[j]);
                }
            }
            down[i] = max + 1;
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, up[i] + down[i]);
        }

        System.out.println(ans - 1);

    }

}
