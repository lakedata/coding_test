package baekjoon_java.SilverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_19637_IF문좀대신써줘 { //이분탐색
    static int[] power;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] title = new String[N];
        int[] titlePower = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            title[i] = st.nextToken();
            titlePower[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());

            int start = 0;
            int last = N - 1;

            while (start <= last) {
                int mid = (start + last) / 2;

                if (titlePower[mid] < num) {
                    start = mid + 1;
                } else {
                    last = mid - 1;
                }
            }
            sb.append(title[start]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
