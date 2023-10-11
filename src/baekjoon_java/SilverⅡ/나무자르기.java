package baekjoon_java.SilverⅡ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무자르기 {//이분탐색 2805번

    public static void main(String[] arg) throws IOException {
        int N, M; //나무의 수, 나무의 길이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int tree[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);

        int max = tree[N - 1];
        long result = BSearch(tree, M, max);
        System.out.println(result);
        br.close();
    }

    public static long BSearch(int[] arr, int m, int max) {
        int min = 0;
        int mid;

        while (min <= max) {
            long sum = 0;
            mid = (min + max) / 2;

            for (long treeHeight : arr) {
                if (treeHeight > mid) {
                    sum += treeHeight - mid;
                }
            }

            if (sum < m) max = mid - 1;
            else min = mid + 1;
        }
        return (min + max) / 2;
    }
}
