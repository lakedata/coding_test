import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 검증수 {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int temp = Integer.parseInt(st.nextToken());
            sum += temp * temp;
        }
        int result = sum % 10;
        System.out.println(result);
    }
}
