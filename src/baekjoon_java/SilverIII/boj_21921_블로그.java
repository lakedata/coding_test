package baekjoon_java.SilverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_21921_블로그 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        //누적합 -  슬라이딩 윈도우 기법 사용

        // X일 마다의 방문자수의 합
        int sum = 0;
        for (int i = 0; i < x; i++) sum += arr[i];

        int max = sum;
        int maxCnt = 1;
        for (int i = x; i < n; i++) {
            sum += arr[i] - arr[i - x]; //새롭게 나타나는 요소 더하기, 첫 요소 제외

            if (max == sum) maxCnt++;
            else if (max < sum) {
                max = sum;
                maxCnt = 1;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(maxCnt);

    }
}
