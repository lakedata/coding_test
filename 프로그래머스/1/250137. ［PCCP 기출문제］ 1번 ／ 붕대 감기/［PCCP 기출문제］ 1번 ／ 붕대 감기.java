import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int cnt = bandage[0];
        int answer = health;
        int std = 0;

        int v1, v2; 
        for (int[] atk: attacks) {
            if (answer <= 0) {
                return -1;
            }

            v1 = atk[0] - std - 1;
            v2 = v1 / cnt;

            std = atk[0];
            answer = Math.min(health, answer + (v1 * bandage[1]));
            answer = Math.min(health, answer + (v2 * bandage[2]));
            answer -= atk[1];
        }        
        return answer <= 0 ? -1 : answer;
    }
}