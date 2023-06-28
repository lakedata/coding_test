import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AdivideB { //1008번
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        double A = Double.parseDouble(st.nextToken()); //실수 자료형
        double B = Double.parseDouble(st.nextToken());

        System.out.print(A / B);
    }
}
