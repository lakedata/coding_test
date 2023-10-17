import java.io.*;

/**
 * 백준 11654번 아스키 코드 (https://www.acmicpc.net/problem/11654)
 */
public class 아스키코드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();  //우선 String형으로 입력
        char c = s.charAt(0);  //그 다음에 글자를 char 형으로 변환
        System.out.print((int)c);  //char형에서 int형으로 변환 후 출력
    }
}
