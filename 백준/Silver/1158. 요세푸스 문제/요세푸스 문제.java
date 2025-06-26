import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        System.out.print("<");
        while(deque.size() > 0) {
            for(int i = 0 ; i < K - 1; i++) {
                deque.addLast(deque.pollFirst());
            }
           
            if(deque.size() == 1)
                 System.out.print(deque.pollFirst());
            else 
               System.out.print(deque.pollFirst() + ", ");      
        }
        System.out.print(">");
    }
}