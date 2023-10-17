import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2501번 약수 구하기 (https://www.acmicpc.net/problem/24418)
 */
public class 약수구하기 {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());//N의 약수
        int K = Integer.parseInt(st.nextToken());//K번째
        int result = 0, count = 0;

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) count++;

            if (count == K) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
