import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] parents;
    
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        parents = new int[n + 1];
        for(int i = 1; i <= n; i++) parents[i] = i;

        for(int i = 1; i <= n; i++)  {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1)  union(i , j);
            }
        }

        String res = "YES";
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        for(int i = 1; i < m; i++)  {
            int y = Integer.parseInt(st.nextToken());
            if (find(x) != find(y)) { 
                res = "NO";
                break;
            }
        }    
        System.out.println(res);
    }
    
    private static int find(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    
    private static void union(int x, int y) {
        int p1 = find(x);
        int p2 = find(y);

        if (x == y) return;
        
        if(p1 < p2) 
            parents[p2] = p1; 
        else
            parents[p1] = p2; 
    }
}