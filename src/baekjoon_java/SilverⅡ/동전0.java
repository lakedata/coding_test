package baekjoon_java.SilverⅡ;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전0 {
    public static void main(String[] arg) throws IOException {

        int N, K; //종류, 가치

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int coin[] = new int[N];

        for(int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for(int i = N - 1; i >= 0; i--) {
            if(K / coin[i] > 0) {
                count += K / coin[i];
                K = K % coin[i];
            }
        }
        System.out.println(count);
    }

}
