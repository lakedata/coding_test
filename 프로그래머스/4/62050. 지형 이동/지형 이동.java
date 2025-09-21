import java.util.*;
import java.io.*;

class Solution {
    static int []dx = {-1, 1, 0, 0};
    static int []dy = {0, 0, -1, 1};
    static boolean [][]vis;
    static int n, m;
    
    static class Pair {
        int x, y, cost;
        
        Pair(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    
    public int solution(int[][] land, int height) {  
        n = land.length;
        m = land[0].length;
        vis = new boolean[n][m]; 
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2)-> Integer.compare(o1.cost, o2.cost)); //주변 비용을 정렬(우선순위 큐)
        pq.add(new Pair(0, 0, 0));
          
        int answer = 0;        
        while(!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (vis[cur.x][cur.y]) continue;
            vis[cur.x][cur.y] = true;
            answer += cur.cost;
            
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];  
                
                if(nx < 0 || nx >= n|| ny < 0 || ny >= m) continue;
                if (vis[nx][ny]) continue;
              
                int diff = Math.abs(land[nx][ny] - land[cur.x][cur.y]);
                int cost = diff > height ? diff : 0;
                pq.add(new Pair(nx, ny, cost));
            }
        }
        return answer;
    }
}