import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1676_팩토리얼0의개수 { //유형: 수학 , 메모리제한: 128MB, 시간 제한: 2초
    static int count = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (N > 0) {
            count += N / 5;
            N /= 5;
        }
        System.out.println(count);
    }
}
