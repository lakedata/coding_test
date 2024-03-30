package baekjoon_java.SilverI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1446_지름길 { //DP(다이나믹 프로그래밍)/최단경로, 메모리 제한:128 MB, 시간 제한: 2초
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] dp = new int[D + 1];
        int[][] shortDis = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            shortDis[i][0] = Integer.parseInt(st.nextToken()); // 시작 위치
            shortDis[i][1] = Integer.parseInt(st.nextToken()); // 도착 위치
            shortDis[i][2] = Integer.parseInt(st.nextToken()); // 지름길의 길이
        }

        for (int i = 0; i <= D; i++) {
            dp[i] = i;
        }
        for (int i = 0; i <= D; i++) {
            dp[i] = Math.min(dp[i], i); // 직접 가는 경우를 고려하여 최소 거리 갱신
            for (int j = 0; j < N; j++) {
                if (i == shortDis[j][0] && shortDis[j][1] <= D) { // 해당 지름길을 탈 수 있는 경우
                    dp[shortDis[j][1]] = Math.min(dp[shortDis[j][1]], dp[i] + shortDis[j][2]);
                }
            }
            if (i + 1 <= D) { // 직진하는 경우
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            }
        }
        System.out.println(dp[D]);
    }
}
