import java.io.IOException;
import java.util.Scanner;

public class 팩토리얼2 {
    public static void main (String arg[]) throws IOException {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        System.out.println(fact(N));
    }
    public static long fact(int N) {
        if(N <= 1)
            return 1;
        else
            return N * fact(N-1);
    }
}
