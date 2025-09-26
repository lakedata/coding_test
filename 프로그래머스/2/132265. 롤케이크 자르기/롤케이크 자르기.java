import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> total = new HashMap<>();
        for(int t : topping) {
            total.put(t, total.getOrDefault(t, 0) + 1);
        }
    
        HashSet<Integer> old = new HashSet<>();
        
        for(int t : topping) {
            old.add(t);
            total.put(t, total.get(t) - 1);
            
            if(total.get(t) == 0)
                total.remove(t);
            
            if(total.size() == old.size())
                answer++;
        }   
        
        return answer;
    }
}