package baekjoon_java.SilverIV;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드2 { //10816번 이분탐색
    static long card1[];
    static long card2[];

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        card1 = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card1[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card1);//오름차순 정렬
        //System.out.println("Sorted arr[] : " + Arrays.toString(card1));

        int M = Integer.parseInt(br.readLine());
        card2 = new long[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            card2[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int cnt = upperBound(card1, card2[i]) - lowerBound(card1, card2[i]);
            bw.write(cnt + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }


    private static int lowerBound(long[] arr, long key) {//하한
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {// lo가 hi랑 같아질 때 까지 반복

            int mid = (lo + hi) / 2;

            if (key <= arr[mid]) {// key 값이 중간 위치의 값보다 작거나 같을 경우
                hi = mid;
            } else {
                lo = mid + 1;
            }

        }
        return lo;
    }

    private static int upperBound(long[] arr, long key) {//상한
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {// lo가 hi랑 같아질 때 까지 반복

            int mid = (lo + hi) / 2;

            if (key < arr[mid]) {// key값이 중간 위치의 값보다 작을 경우
                hi = mid;
            } else { // 중복원소의 경우 else에서 처리된다.
                lo = mid + 1;
            }
        }
        return lo;
    }
}
