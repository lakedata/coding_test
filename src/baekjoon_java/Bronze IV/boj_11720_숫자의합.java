import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class boj_11720_숫자의합 { //문제유형: 구현 , 메모리 제한: 256MB, 시간 제한: 1초
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += str.charAt(i) - '0';
        }
        System.out.println(sum);
    }
}
