package baekjoon_java.GoldIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1806_부분합 { //투 포인터
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = 0;
        int min = Integer.MAX_VALUE;
        while (start < N) {
            if (end < N && sum < S)
                sum += arr[end++];
            else
                sum -= arr[start++];

            if (sum >= S) {
                if (min > end - start) min = end - start;
            }
        }
        if (min != Integer.MAX_VALUE)
            System.out.println(min);
        else
            System.out.println(0);
    }
}
