package baekjoon_java.SilverIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_10828_스택 { //문제유형: 스택 , 메모리 제한: 256MB, 시간 제한: 0.5초
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            } else if (str.equals("pop")) {
                if (stack.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(stack.pop());
            } else if (str.equals("size")) {
                System.out.println(stack.size());
            } else if (str.equals("empty")) {
                System.out.println(stack.isEmpty() ? "1" : "0");
            } else if (str.equals("top")) {
                if (stack.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(stack.peek());
            }
        }
    }
}
