import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max;

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] a = new int[1000];
        int[] b = new int[1000];
        int[] c  = new int[1000];

        int i = 0;
        while (true) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());

            if (a[i] == 0 && b[i] == 0 && c[i] == 0)
                break;

            i++;
        }

        for (int j = 0; j < i; j++) {
            int max = Math.max(Math.max(a[j], b[j]), c[j]);

            if (a[j] == b[j] && b[j] == c[j])
                System.out.println("Equilateral");
            else if (max >= (a[j] + b[j] + c[j]) - max)
                System.out.println("Invalid");
            else if (a[j] == b[j] || a[j] == c[j] || b[j] == c[j])
                System.out.println("Isosceles");
            else
                System.out.println("Scalene");
        }
    }
}