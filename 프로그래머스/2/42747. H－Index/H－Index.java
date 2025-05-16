import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Integer[] boxed = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, Collections.reverseOrder());

        for(int h = 1; h <= citations.length; h++) {
            if(h <= boxed[h-1]) answer = h;
            else break;
        }
        return answer;
    }
}