import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열 { //9086번
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String s = br.readLine();//readLine() 메서드는 값을 읽어올 때, String값으로 개행문자(엔터값)를 포함해 한줄을 전부 읽어오는 방식

            /*append()를 사용하여 StringBuilder에 값을 저장한다.
             charAt() ()안의 index값의 위;치의 문자를 출력한다.*/
            sb.append(s.charAt(0));
            sb.append(s.charAt(s.length() - 1) + "\n");
        }
        System.out.println(sb);

    }

}
