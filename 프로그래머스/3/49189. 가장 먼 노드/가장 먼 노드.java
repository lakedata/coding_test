import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] e: edge) { //간선 연결
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        int []distance = new int[n + 1];
        Arrays.fill(distance, -1);
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        distance[1] = 0;
            
        while(!que.isEmpty()) {
            int current = que.poll();
            for(int neighoor : graph.get(current)) {
                if(distance[neighoor] == -1) {
                    distance[neighoor] = distance[current] + 1;
                    que.add(neighoor);
                }
            }
        }
        
        int maxDist = 0;
        for(int d: distance) {
            if(maxDist < d)
                maxDist = d;
        }
        
        int count = 0;
        for(int d: distance) {
            if(maxDist == d)
                count += 1;
        }
        return count;
    }
}