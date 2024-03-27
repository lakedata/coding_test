package baekjoon_java.SilverⅡ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_1406_에디터 { //스택(Stack)
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        String str = br.readLine();
        int N = str.length();
        for (int i = 0; i < N; i++) {
            left.push(str.charAt(i));
        }
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("P")) { //문자 추가
                char add = st.nextToken().charAt(0);
                left.push(add);
            } else if (command.equals("L")) { //커서 왼쪽 이동
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }
            }else if (command.equals("D")) { //커서 오른쪽 이동
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
            }else if (command.equals("B")) { //커서 왼쪽 문자 삭제
                if (!left.isEmpty()) {
                    left.pop();
                }
            }
        }

        while (!left.isEmpty()) {
            right.push(left.pop()); //합침
        }
        while (!right.isEmpty()) {
            sb.append(right.pop()); //역순 출력
        }
        System.out.println(sb.toString());
    }
}
