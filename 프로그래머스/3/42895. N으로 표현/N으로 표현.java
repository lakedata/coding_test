class Solution {
    int answer = -1;
    
    public int solution(int N, int number) {
        dfs(0, 0, N, number);
        return answer;
    }
    public void dfs(int count, int now, int N, int number) {
        if(count > 8)
            return;
        
        if(now == number) {
            if(answer == -1 || answer > count) 
                answer = count;
            return;
        }

        int nn = N;
        for(int i = 0; i < 8 - count; i++) {
            dfs(count + i + 1, now + nn, N, number);
            dfs(count+ i + 1, now - nn, N, number);
            dfs(count + i + 1, now / nn, N, number);
            dfs(count + i + 1, now * nn, N, number);
            
            nn = nn * 10 + N;
        }
    }
}