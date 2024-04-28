import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_11866_요세푸스문제0 { //유형: 큐(Queue) , 메모리제한: 256 MB, 시간 제한: 1초
    static int N;
    static int K;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        System.out.print("<");
        while (!q.isEmpty()) {
            for (int i = 1; i < K; i++) {
                q.add(q.poll());
            }
            if (q.size() == 1)
                System.out.print(q.poll());
            else
                System.out.print(q.poll() + ", ");
        }
        System.out.print(">");
    }
}
