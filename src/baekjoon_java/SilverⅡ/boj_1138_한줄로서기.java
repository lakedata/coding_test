package baekjoon_java.SilverⅡ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1138_한줄로서기 { //유형: 구현, 메모리 제한: 128 MB , 시간 제한: 2 초

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] tallerCount = new int[N]; //키가 큰 사람이 왼쪽에 몇 명
        int[] line = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tallerCount[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int taller = tallerCount[i];
            for (int j = 0; j < N; j++) {
                if (taller == 0 && line[j] == 0) {
                    line[j] = i + 1;
                    break;
                } else if (line[j] == 0) {
                    taller--;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(line[i] + " ");
        }
    }
}
