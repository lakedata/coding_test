import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int bitSet = 0;
        int m = Integer.parseInt(br.readLine());
        
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String com = st.nextToken();
            
            if (com.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                bitSet |= (1 << (x - 1));
            } else if (com.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                bitSet &= ~(1 << (x - 1));
            } else if (com.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                sb.append((bitSet & (1 << (x - 1))) != 0 ? 1 : 0).append("\n");
            } else if (com.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                bitSet ^= (1 << (x - 1));
            } else if (com.equals("all")) {
                bitSet = (1 << 20) - 1;
            } else if (com.equals("empty")) {
                bitSet = 0;
            }
        }
        
        System.out.print(sb);
    }
}
