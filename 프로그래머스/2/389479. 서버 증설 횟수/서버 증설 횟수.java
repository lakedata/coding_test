
import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        
        for(int t = 0; t < 24; t++) {
            while(!pq.isEmpty() && pq.peek() <= t) {//끝난 서버 제거
                pq.poll();
            }
            
            int need = players[t] / m;
            if(need > pq.size()) {
                for(int i = pq.size(); i < need; i++) {
                    pq.add(t + k);//종료시각
                    answer++;
                }
            }
        }
        return answer;
    }
}