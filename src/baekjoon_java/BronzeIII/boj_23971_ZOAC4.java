package baekjoon_java.BronzeIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_23971_ZOAC4 {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H, W, N, M;
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int i = 0; i < H; i += N + 1) {
            for (int j = 0; j < W; j += M + 1) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
