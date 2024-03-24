package baekjoon_java.SilverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2559_수열 { //누적합
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] array = new int[N + 1];
        int[] prefix_sum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            prefix_sum[i + 1] = prefix_sum[i] + array[i];
        }

        int max = -9999;
        int i = 0;
        int sum = 0;
        while(i + K <= N) {
               sum  = prefix_sum[K + i] - prefix_sum[i];

               if(N == 1)
                    sum = array[0];

            if (max < sum)
                max = sum;
            i++;
        }
        System.out.println(max);
    }
}
