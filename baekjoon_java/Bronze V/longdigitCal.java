import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class longdigitCal { //2338번 긴자리 계산
    public static void main(String arg[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));//BufferedReader선언

        BigInteger a = new BigInteger(bf.readLine());
        BigInteger b = new BigInteger(bf.readLine());

        System.out.println(a.add(b));
        System.out.println(a.subtract(b));
        System.out.print(a.multiply(b));
    }
}
/*
문제 접근 과정
-입력 조건을 보면 10진수로 1,000자리를 넘지 않는 수
-int가 아닌 문자열 형태로 이루어져 있어 숫자의 범위가 무한인
BigInteger를 이용해 문제에 접근

⊙ BigInteger
int와 BigInteger의 차이점
       int의 범위는 '-2,147,483,648~2,147,483,647'이지만
       BigInteger의 범위는 문자열 형태로 이루어져 있어 무한이다.

BigInteger 계산법
      문자열 형태로 이루어져 있기에 사칙연산이 안된다.
      따라서 BigInteger의 값을 계산을 하려면 클래스 내부의 함수를 이용해야 한다.

      더하기 : add()
      빼   기 : subtract()
      곱하기 : multiply()
      나누기 : divide()
* */