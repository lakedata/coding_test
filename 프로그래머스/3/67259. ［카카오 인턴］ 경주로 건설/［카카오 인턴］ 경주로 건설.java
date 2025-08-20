import java.util.*;

class Solution {
    private static class Node {
        int x, y, direction, cost;
        public Node(int x, int y, int direction, int cost) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }
    }
    private static int dx[] = {-1, 1, 0, 0};
    private static int dy[] = {0, 0, -1, 1};
    private static int N;
    private static int[][][] visited;

    private static int calculateCost(int direction, int prevDirection, int cost) {
        if(prevDirection == -1 || prevDirection / 2 == direction / 2)
            return cost + 100;
        return cost + 600;
    }
    
    private static boolean isShouldUpdate(int x, int y, int direction, int newCost) { 
        return visited[x][y][direction] == 0 || visited[x][y][direction] > newCost;           
    }
    
    public int solution(int[][] board) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, -1, 0));
        N = board.length;
        visited = new int[N][N][4];
        
        int answer = Integer.MAX_VALUE;
        
        while(!que.isEmpty()) {
            Node now = que.poll();
            
            for(int i = 0; i < 4; i++) {
                int new_x = now.x + dx[i];
                int new_y = now.y + dy[i];
                
                if(new_x < 0 || new_x >= N || new_y < 0 || new_y >= N) //범위
                    continue;
                
                if(board[new_x][new_y] == 1) //이동X
                    continue;
                
                int new_cost = calculateCost(i, now.direction, now.cost); //비용계산
                
                if(new_x == N - 1 && new_y == N - 1) {
                    answer = Math.min(answer, new_cost);
                }
                
                else if(isShouldUpdate(new_x, new_y, i, new_cost)) { //최소 비용
                    que.add(new Node(new_x, new_y, i, new_cost));
                    visited[new_x][new_y][i] = new_cost; 
                }
            }
        }
        return answer;
    }
}