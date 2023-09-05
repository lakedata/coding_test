import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 국회의원선거 {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        //다른 후보 투표수 내림차순 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        //다른 후보 투표수 저장
        while (n-- > 1) pq.add(Integer.parseInt(br.readLine()));
        int cnt = 0;

        //다른 후보의 사람들 매수 진행
        while (!pq.isEmpty() && pq.peek() >= a) {
            cnt++;
            a++;//매수 횟수 +1
            pq.add(pq.poll() - 1);//가장 큰 후보 투표수 -1
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new 국회의원선거().solution();
    }
}