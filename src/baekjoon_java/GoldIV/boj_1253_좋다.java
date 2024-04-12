package baekjoon_java.GoldIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1253_좋다 {
    public static void main(String args[]) throws IOException { //문제유형: 투포인터 , 메모리 제한: 256MB, 시간 제한: 2초
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < N; i++) {
            int start = 0, end = N - 1;
            long target = arr[i];

            while (start < end) {
                if (start == i) {
                    start++;
                    continue;
                }
                if (end == i) {
                    end--;
                    continue;
                }

                long sum = arr[start] + arr[end];
                if (sum == target) {
                    count++;
                    break;
                } else if (sum < target) {
                    start++;
                } else if (sum > target) {
                    end--;
                }
            }
        }
        System.out.println(count);
    }
}
