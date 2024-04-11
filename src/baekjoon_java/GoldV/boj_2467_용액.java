package baekjoon_java.GoldV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2467_용액 { //문제유형: 투포인터 , 메모리 제한: 128MB, 시간 제한: 1초
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = N - 1;
        int ws = 0, we = 0;
        long water = Integer.MAX_VALUE;
        while (start < end) {
            long sum = arr[start] + arr[end];
            if (water > Math.abs(sum)) {
                water = Math.abs(sum);
                ws = start;
                we = end;
            }

            if (sum >= 0) {
                end--;
            } else {
                start++;
            }
        }
        System.out.print(arr[ws] + " " + arr[we]);
    }
}
