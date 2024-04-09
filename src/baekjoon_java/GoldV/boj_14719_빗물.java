package baekjoon_java.GoldV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14719_빗물 { //문제유형: 구현, 메모리 제한: 256KB, 시간 제한: 1초
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 1; i < W - 1; i++) {
            int left = 0;
            int right = 0;

            // 왼쪽으로 가장 높은 벽
            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }

            // 오른쪽으로 가장 높은 벽
            for (int j = i + 1; j < W; j++) {
                right = Math.max(right, arr[j]);
            }

            // 현재 위치에서 고이는 빗물의 양 계산하여 결과에 더하기
            int minWall = Math.min(left, right);
            if (minWall > arr[i]) {
                result += minWall - arr[i];
            }
        }

        System.out.println(result);
    }
}
