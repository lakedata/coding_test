class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCnt = 0;
        int sameCnt = 0;
        
        for(int lotto : lottos) {
            if(lotto == 0) {
                zeroCnt++;
                continue;
            }
            for(int win_num : win_nums) {
                if(lotto == win_num) {
                    sameCnt++;
                    break;
                }
            }
        }        

        answer[0] = getRank(sameCnt + zeroCnt);
        answer[1] = getRank(sameCnt);
        
        return answer;
    }
    public int getRank(int same) {
        int rank;
        switch(same) {
            case 6: rank = 1;
                break;
            case 5: rank = 2;
                 break;
            case 4: rank = 3;
                 break;
            case 3: rank = 4;
                 break;
            case 2: rank = 5;
                 break;
            default: rank = 6;
        }
         return rank;
    }
}