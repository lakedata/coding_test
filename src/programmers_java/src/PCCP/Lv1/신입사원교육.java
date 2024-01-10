package PCCP.Lv1;

import java.util.*;

public class 신입사원교육 { //그리디, 힙
        public int solution(int[] ability, int number) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int a : ability) {
                pq.offer(a);
            }

            for (int i = 0; i < number; i++) {
                int sum = pq.poll() + pq.poll();

                for (int j = 0; j < 2; j++) {
                    pq.offer(sum);
                }
            }

            while (!pq.isEmpty()) {
                answer += pq.poll();
            }

            return answer;
        }
}

