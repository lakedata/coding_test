package baekjoon_java.GoldII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 12015번 가장 긴 증가하는 부분 수열 2 (https://www.acmicpc.net/problem/12015)
 */
public class 가장긴증가하는부분수열2 {
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        arr = new int[A];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[A];
        dp[0] = arr[0];
        int x = 0;

        for (int i = 0; i < A; i++) {
            if (arr[i] > dp[x]) {
                dp[++x] = arr[i];
            } else {
                int targetIdx = binarySearch(x, arr[i]);
                dp[targetIdx] = arr[i];
            }
        }
        System.out.println(x + 1);

    }

    public static int binarySearch(int high, int target) {
        int low = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (dp[mid] < target) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }

}
