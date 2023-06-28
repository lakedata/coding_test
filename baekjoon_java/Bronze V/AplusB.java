import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AplusB { //1000번
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));//BufferedReader선언

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");//공백단위로 읽어드릴수 있는 라인 추가
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.print(A + B);
    }
}
