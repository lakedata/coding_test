package baekjoon_java.SilverⅡ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // (이전 배열의 누적합 + 현재 값)과 현재 값을 비교하여 최댓값을 N위치에 저장
        dp[0] = arr[0];//0은 탐색하지 않아도 됌
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            // (현재 arr값 + 이전 dp) 과 현재 arr값 중 큰 것을 dp에 저장
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
