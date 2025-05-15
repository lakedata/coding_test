import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int length = commands.length;
        int[] answer = new int[length];
        
        for(int i = 0; i < length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];
            
            int []cut = Arrays.copyOfRange(array, start-1, end);
            Arrays.sort(cut);
            answer[i] = cut[k-1];
        }
        return answer;
    }
}