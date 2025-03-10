import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 참가자의 수
        double zimin = Integer.parseInt(st.nextToken()); // 지민
        double hansu = Integer.parseInt(st.nextToken()); // 현수
        
        int count = 0;
        while (zimin != hansu) {
            zimin = Math.round(zimin / 2); 
            hansu = Math.round(hansu / 2); 
            count++;
        }
        System.out.println(count);
    }
}