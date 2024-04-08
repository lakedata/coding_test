package baekjoon_java.GoldV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2493_탑 {
    public static void main(String args[]) throws IOException { //문제유형: 스택 , 메모리제한: 128 MB, 시간 제한: 1.5초
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                if (stack.peek()[1] < height) stack.pop();
                else { // 이전 탑의 높이가 현재 높이보다 크면
                    System.out.print(stack.peek()[0] + " ");
                    break;
                }
            }

            if (stack.isEmpty()) System.out.print("0 ");
            stack.push(new int[]{i, height});
        }
    }
}
