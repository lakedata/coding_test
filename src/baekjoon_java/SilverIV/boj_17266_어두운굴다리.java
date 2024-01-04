package baekjoon_java.SilverIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17266_어두운굴다리 {
    static int n;
    static int m;
    static int[] light;

    public static void main(String argp[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        light = new int[m];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            light[i] = Integer.parseInt(st.nextToken());
        }
        BSearch(n);
    }

    // 이분탐색 - 반복적 탐색
    public static void BSearch(int n) {
        int left = 1; // 굴다리 최소 길이
        int right = n; // 굴다리 길이가 최대
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (possible(mid)) {
                result = mid;
                right = mid - 1;
            }
            // 모든 지점을 비출 수 없다면 높이를 높여 재탐색
            else
                left = mid + 1;
        }
        System.out.println(result);
    }

    static boolean possible(int target) {
        int prev = 0; // 이전 가로등이 비춘 마지막 지점

        for (int i = 0; i < light.length; i++) {
            if (light[i] - target <= prev) {
                prev = light[i] + target;
            } else {
                return false;
            }
        }
        // 마지막 가로등부터 끝 지점도 확인
        return n - prev <= 0;
    }
}
