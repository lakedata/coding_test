package baekjoon_java.SilverⅡ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_18870_좌표압축 { //문제유형: 정렬, 값 / 좌표 압축 , 메모리 제한: 512MB, 시간 제한: 1초
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열을 복사하여 정렬하고 중복된 값 제거
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int value : sortedArr) {
            if (!map.containsKey(value)) {
                map.put(value, idx++);
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb.toString());
    }
}
