package baekjoon_java.SilverI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20922_겹치는건싫어 { //유형: 투 포인터 , 메모리 제한: 1024 MB, 시간 제한: 1초
    static int[] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //길이
        int K = Integer.parseInt(st.nextToken()); //촤장 연속 부분 수열 길이
        arr = new int[N];
        int[] count = new int[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, len = 0;
        while (start < N) {
            while (end < N && count[arr[end]] + 1 <= K) {
                count[arr[end++]]++;
            }
            len = Math.max(len, end - start);
            count[arr[start++]]--;
        }
        System.out.println(len);
    }
}
