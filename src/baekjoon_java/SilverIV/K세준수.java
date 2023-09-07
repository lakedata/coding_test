package baekjoon_java.SilverIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class K세준수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int cnt = 0;

        for (int i = 2; i <= N; i++) {
            if (arr[i] != 0)
                continue;
            for (int j = i; j <= N; j += i) {
                arr[j] = Math.max(arr[j], i);//소인수 최대값
            }
        }
        for (int i = 1; i <= N; i++) {
            if (arr[i] <= K)
                cnt++;
        }
        System.out.println(cnt);
    }
}
