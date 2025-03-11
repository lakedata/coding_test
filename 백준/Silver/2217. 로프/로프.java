import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 로프 수
        Integer []rope = new Integer[n];
        for(int i = 0; i < n; i++) {
            rope[i] =  Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope, Collections.reverseOrder());

        int answer = 0;
        for(int i = 0; i < n; i++) {
            answer = Math.max(answer, rope[i] * (i + 1));
        }
        System.out.println(answer);
    }
}