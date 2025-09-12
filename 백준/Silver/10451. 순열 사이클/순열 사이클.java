import java.util.*;
import java.io.*;

class Main {
    static int cycle = 0;
    static int[]parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            parents = new int[n + 1];
            cycle = 0;
            for (int i = 1; i <= n; i++) parents[i] = i;
            
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                int a = i;
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
            System.out.println(cycle);
        }
        
    }
    public static void union(int x, int y){
        int p1 = find(x);
        int p2 = find(y);

        if(p1 == p2) cycle++;
        else if(p1 < p2)
            parents[p2] = p1;
        else
             parents[p1] = p2;
        
            
    }
    public static int find(int x){
        if(parents[x] == x)    return x;
        return parents[x] = find(parents[x]);
    }
}