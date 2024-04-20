package baekjoon_java.SilverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj_18115_카드놓기 { //유형: 덱, 메모리제한: 1024 MB, 시간 제한: 2초
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N+1];

        StringTokenizer st = new StringTokenizer(new StringBuilder(br.readLine()).reverse().toString());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());

            switch (A[i]) {
                case 1: // 제일 위의 카드 1장 바닥에 내려놓기
                    deque.addFirst(i); // Deque의 앞쪽에 데이터를 삽입, 용량 초과시 Exception
                    break;
                case 2: //위에서 두 번째 카드 바닥에 내려놓기
                    int top = deque.removeFirst(); // Deque의 앞에서 제거, 비어있으면 예외
                    deque.addFirst(i);
                    deque.addFirst(top);
                    break;
                case 3: // 제일 밑 카드 바닥에 내려놓기
                    deque.addLast(i); // 마지막에 원소 삽입 용량 초과 시 예외 발생
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst()).append(" ");
        }

        System.out.println(sb);
    }
}
