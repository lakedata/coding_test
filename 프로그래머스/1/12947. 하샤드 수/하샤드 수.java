class Solution {
    public boolean solution(int x) {
        int sum = 0;
        String str = Integer.toString(x);
        char[] ch = str.toCharArray();
        
        for(int i = 0; i < ch.length; i++) {
            sum += ch[i] - '0';
        }
        
        if(x % sum == 0)
            return true;
        
        return false;
    }
}