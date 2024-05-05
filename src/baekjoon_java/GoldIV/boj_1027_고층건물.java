package baekjoon_java.GoldIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1027_고층건물 { // 유형: 브루트포스, 메모리제한: 128MB, 시간 제한: 2초
    static int N;
    static int[] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, Count(i)); // 모든 빌딩 기준
        }
        System.out.println(result);
    }

    public static int Count(int idx) {
        int cnt = 0;

        //오른쪽 - 기울기 증가
        double maxSlope = -1000000000;

        for (int i = idx + 1; i <= N; i++) {
            double slope = (double) (arr[idx] - arr[i]) / (idx - i);

            if (maxSlope < slope) {
                maxSlope = slope;
                cnt++;
            }
        }

        //왼쪽 - 기울기 감소
        double minSlope = 1000000000;
        for (int i = idx - 1; i >= 1; i--) {
            double slope = (double) (arr[idx] - arr[i]) / (idx - i);

            if (minSlope > slope) {
                minSlope = slope;
                cnt++;
            }
        }
        return cnt;
    }
}
