import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static List<Integer>[] graph;
    static int[] indegree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        indegree = new int[n + 1];  
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            indegree[b]++;
        }
        System.out.println(topologicalSort());
    }
    static String topologicalSort() {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> que = new LinkedList<>();


        for(int i = 1; i <= n; i++) { //차수가 0인 노드 큐에 넣기
            if (indegree[i] == 0) {
                que.add(i);
            }
        }
        
         while(!que.isEmpty()) {
             int current = que.poll();
             sb.append(current).append(' ');

             for(int next : graph[current]) {
                 indegree[next]--;
                 if (indegree[next] == 0) {
                      que.add(next);
                }
             }
         }
        return sb.toString();
    }
}