import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 수열 B의 길이
        int[] A = new int[n]; // 수열 A
        int sum = 0; // 누적 합
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int B = Integer.parseInt(st.nextToken());
            A[i] = B * (i + 1) - sum; // 원래의 A 값을 복원
            sum += A[i];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + " ");
        }
    }
}