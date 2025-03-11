import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken());

        int row = h / (n + 1) + (h % (n + 1) == 0 ? 0 : 1);
        int col = w / (m + 1) + (w % (m + 1) == 0 ? 0 : 1);
        result = row * col;
        
        System.out.println(result);
    }
}