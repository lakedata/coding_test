package baekjoon_java.GoldIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {//2110번 이분탐색
    static int N, C;
    static int[] house;

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());// 집의 개수
        C = Integer.parseInt(st.nextToken());// 공유기 개수
        house = new int[N]; //실수 주의

        for (int i = 0; i < N; i++)
            house[i] = Integer.parseInt(br.readLine());
        Arrays.sort(house);

        int result = BSearch(house, C);
        System.out.println(result);
        br.close();
    }

    public static int BSearch(int[] arr, int c) {
        int min = 1; // 최소길이
        int max = arr[arr.length - 1] - arr[0];// 최대길이
        int dis = 0;

        while (min <= max) {
            int mid = (min + max) / 2;
            int cnt = 1; // 공유기 설치 개수
            int previous = arr[0]; //최근에 공유기를 놓은 집

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] - previous >= mid) {//(최소거리)최근 공유기를 놓은 집부터 다음 타켓 까지의 거리
                    cnt++;
                    previous = arr[i];
                }
            }

            if (cnt >= c) {
                // 실제 설치될 공유기보다 많이 설치함 -> 오른쪽으로 이동해 더 긴 간격 찾아야함
                min = mid + 1;
                dis = mid;
            } else if (cnt < c) {
                // 공유기를 c보다 적게 설치함 -> 왼쪽으로 이동해 더 짧은 간격 찾아야함
                max = mid - 1;
            }
        }
        return dis;
    }
}

