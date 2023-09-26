import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] road = new long[N - 1];
        long[] fuel = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fuel[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        long MIN = Integer.MAX_VALUE;

        for (int i = 0; i < N-1; i++) {
            MIN = Math.min(MIN, fuel[i]);
            sum += road[i] * MIN;
        }
        System.out.println(sum);
    }
}
