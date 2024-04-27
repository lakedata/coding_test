package baekjoon_java.BronzeII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2745_진법변환 { //유형: 구현/문자열, 메모리제한: 128 MB, 시간 제한: 1초
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int num = 0, sum = 0;
        int powNum = 0;
        for (int i = N.length() - 1; i >= 0; i--) {
            char c = N.charAt(i);

            if(c >= 'A' && c <= 'Z')
                num = c - 55; //A~Z는 숫자로 변경 (A가 10이어야 하므로 55를 빼준다)
            else if (c >= '0' && c <= '9')
                num = c - '0'; //0~9 사이는 그대로 출력 (0의 아스키코드 값인 48을 뺀다)
            sum += num * Math.pow(B, powNum++); //2진법의 경우 2^0 2^1 2^2
        }
        System.out.println(sum);
    }
}
