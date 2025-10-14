class Solution {
    public int[] solution(int brown, int yellow) {
        
        int total = brown + yellow;
        int sqrt = (int) Math.sqrt(total);
        
        for(int vertical = 3; vertical <= sqrt; vertical++) {
            if(total % vertical == 0) {
                int horizontal = (int) (total / vertical);
                
                if(brown == (horizontal + vertical) * 2 - 4)  
                    return new int[] {horizontal, vertical}; //가로, 세로
            }
        }
        return new int[]{};
    }
}