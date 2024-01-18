package baekjoon_java.SilverⅡ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2512_예산 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] budget = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        Arrays.sort(budget);

        int left = 0;
        int right = budget[n - 1];

        while (left <= right) {
            int mid = (left + right) / 2;
            long total = 0;

            for (int i = 0; i < n; i++) {
                if (mid < budget[i]) total += mid;
                else total += budget[i];
            }
            if (total <= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        System.out.println(right);

    }

}
