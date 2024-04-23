package baekjoon_java.GoldIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_1863_스카이라인쉬운거 { //유형: 자료구조, 스택 , 메모리제한: 128 MB, 시간 제한: 2초
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > y) { // 이전 높이 > 현재 높이를 비교
                answer++;
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() == y) { //높이가 같다면
                continue;
            }
            stack.push(y);
        }

        while (!stack.isEmpty()) {
            if (stack.peek() > 0) { // 남은 건물
                answer++;
            }
            stack.pop();
        }
        System.out.println(answer);
    }
}
