package baekjoon_java.SilverIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기 { //1920번 이분탐색
    static int[] arrN;
    static int[] arrM;

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arrN = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN);//오름차순 정렬
        //System.out.println("Sorted arr[] : " + Arrays.toString(arrN));

        int M = Integer.parseInt(br.readLine());
        arrM = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            System.out.println(BSearch(arrN, arrM[i]));
        }

    }

    public static int BSearch(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (arr[mid] == n) return 1;

            if (arr[mid] < n) left = mid + 1;
            else if (arr[mid] > n) right = mid - 1;

        }
        return 0;
    }

}
