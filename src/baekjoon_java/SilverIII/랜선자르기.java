package baekjoon_java.SilverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 랜선자르기 { //1654번 이분탐색
    static long[] lines;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        lines = new long[K + 1];
        long result = 0;
        long max = 0;

        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt((br.readLine()));
            max = Math.max(max, lines[i]);
        }

        result = binary_search(lines, N, max);

        System.out.println(result);
        br.close();
    }

    public static long binary_search(long[] arr, int n, long max) {
        long mid;
        long min = 1;

        while (min <= max) {
            mid = (min + max) / 2;
            long count = 0;

            for (long num : arr) {
                count += num / mid;
            }
            if (count < n)
                max = mid - 1;
            else min = mid + 1;
        }
        return (max + min) / 2;
    }

}
