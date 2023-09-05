import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
import java.io.*;
import java.util.*;
 */
public class safariWorld {//2420번
    public static void main(String arg[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        long N = Long.valueOf(st.nextToken());
        long M = Long.valueOf(st.nextToken());

        System.out.println(Math.abs(N-M));
    }
}
/*
N, M을 합친 거리|-2000000000 - 2000000000| 의 경우는 int 이상의 데이터 타입이 필요하다. (long)
int 범위: -2,147,483,648 ~ 2,147,483,647
long범위: -9223372036854775808 ~ 9223372036854775807

절댓값: Math.abs()
double, float, int, long 총 4개의 타입으로 입력이 가능합니다
*/
