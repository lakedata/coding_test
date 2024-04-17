package baekjoon_java.GoldV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj_2669_숫자고르기 { //문제유형: DFS , 메모리 제한: 128MB, 시간 제한: 1초
    static int N; // 숫자의 개수
    static int[] array; // 주어진 숫자 배열
    static boolean[] check; // 방문 여부를 체크하는 배열
    static List<Integer> answer; // 결과를 저장할 리스트

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N + 1];
        check = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        answer = new ArrayList<Integer>();

        // 각 숫자에서부터 DFS 수행
        for (int i = 1; i <= N; i++) {
            check[i] = true;
            dfs(i, i);
            check[i] = false;
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (int num : answer) {
            System.out.println(num);
        }
    }

    private static void dfs(int index, int start) {
        // 현재 숫자를 방문하지 않았고, 현재 숫자의 다음 숫자가 시작 숫자와 같을 때
        if (!check[array[index]]) {
            check[array[index]] = true; // 다음 숫자를 방문 표시
            dfs(array[index], start);
            check[array[index]] = false; // 다음 숫자 방문 해제
        }
        if (array[index] == start) {
            answer.add(start);
        }
    }
}
