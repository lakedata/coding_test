package baekjoon_java.GoldIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13144_ListofUniqueNumbers { //유형: 투 포인터, 메모리제한: 32MB, 시간 제한: 1초
    static int N;
    static int[] arr;
    static int[] cnt = new int[100000 + 1];

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        pro();
    }

    static void pro() {
        long res = 0;
        int start = 0, end = 0;

        while (start < N) {
            while (end < N && cnt[arr[end]] == 0) {
                cnt[arr[end]]++;
                end++;
            }
            res += end - start;

            cnt[arr[start]]--;
            start++;
        }
        System.out.println(res);
    }
}
