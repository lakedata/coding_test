import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1476_날짜계산 {
    public static void main(String argsp[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken()); // 지구
        int S = Integer.parseInt(st.nextToken()); // 태양
        int M = Integer.parseInt(st.nextToken()); // 달

        int Year = 1;
        while (true) {
            if ((Year - E) % 15 == 0 && (Year - S) % 28 == 0 && (Year - M) % 19 == 0)
                break;
            Year++;
        }
        System.out.println(Year);
    }
}
