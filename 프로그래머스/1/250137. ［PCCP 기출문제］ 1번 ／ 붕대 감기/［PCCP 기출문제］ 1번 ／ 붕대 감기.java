class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int attackidx = 0;
        int count = 0;
        
        for(int time = 1; time <= attacks[attacks.length-1][0]; time++) {
            
            if(answer <= 0) break; 
            
            //공격하는 경우
            if (attackidx < attacks.length && time == attacks[attackidx][0]) {
                answer -= attacks[attackidx][1];
            
                if (answer <= 0) return -1;
                count = 0;
                attackidx++;
            }
            //공격하지 않는 경우
            else {                
                //초 체력 회복
                answer += bandage[1];
                count++;
                
                //연속 체력회복
                if(count == bandage[0]) {              
                    answer += bandage[2];
                    count = 0;
                }
                if(answer > health) answer = health;
            }
        }
        return answer;
    }
}