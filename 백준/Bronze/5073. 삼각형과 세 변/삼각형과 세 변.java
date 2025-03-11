import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0 && c == 0)
                break;
            
            int max = -1;
            max = Math.max(max, a);
            max = Math.max(max, b);
            max = Math.max(max, c);

            if(max >= a + b + c - max)
                System.out.println("Invalid");
            else if(a == b && a == c && b == c)
                System.out.println("Equilateral");
            else if(a == b || a == c || b == c)
                System.out.println("Isosceles");
            else if(a != b && a != c && b != c)
                 System.out.println("Scalene");
        }
    }
}