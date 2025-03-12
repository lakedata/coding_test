import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사다리 개수
        int M = Integer.parseInt(st.nextToken()); // 뱀 개수

        int[] board = new int[101];  // 1부터 100까지 칸
        for (int i = 1; i <= 100; i++) {
            board[i] = i; 
        }

        // 사다리 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y; 
        }

        // 뱀 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            board[u] = v;
        }

        // BFS 탐색
        System.out.println(bfs(board));
    }

    public static int bfs(int[] board) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];
        queue.add(1);
        visited[1] = true;

        int count = 0;  // 주사위 굴린 횟수

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();

                if (cur == 100) return count;
                
                for (int dice = 1; dice <= 6; dice++) {
                    int next = cur + dice;
                    
                    if (next > 100) continue; 
                    next = board[next];  // 사다리 또는 뱀 체크

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            count++; 
        }
        return -1;
    }
}