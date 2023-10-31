import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영화감독숌 {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int i = 0;

        while (count != N) {
            i++;

            if (String.valueOf(i).contains("666")) {
                count++;

                if (count == N)
                    System.out.println(i);
            }
        }

    }
}
