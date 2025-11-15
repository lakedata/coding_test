import java.util.*;

class Solution {
    static final int INF = 40000000;
    static int[][] graph = new int[200][200];
    
    void floyd(int n) {
        for(int k = 0; k < n; ++k) {
            for(int i = 0; i < n; ++i) {
                for(int j = 0; j < n; ++j) {
                    if(graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];   
                    }
                }
            }
        }
    }
    public int solution(int n, int s, int a, int b, int[][] fares) {
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(i == j)
                    graph[i][j] = 0;
                else 
                    graph[i][j] = INF;
            }
        }
        
        for(int[] edge : fares) {
            graph[edge[0]-1][edge[1]-1] = edge[2];
            graph[edge[1]-1][edge[0]-1] = edge[2];
        }
        
        floyd(n);
        
        --s;
        --a;
        --b;
        int answer = INF;
        for(int k = 0; k < n; ++k) {
            answer = Math.min(answer, graph[s][k] + graph[k][a] + graph[k][b]);
        }        
        return answer;
    }
}