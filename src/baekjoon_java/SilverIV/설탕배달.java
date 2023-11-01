package baekjoon_java.SilverIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*https://www.acmicpc.net/problem/2839
  브루트 포스 알고리즘, 14324KB 124ms
*/
public class 설탕배달 {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while (N % 5 != 0) {
            N -= 3;
            count++;
        }
        if (N < 0) System.out.println(-1);
        else {
            count += N / 5;
            System.out.println(count);
        }
    }
}