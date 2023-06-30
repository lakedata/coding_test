import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class superRich2 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        System.out.println(n.divide(m) + "\n" + n.remainder(m));
    }
}

/*
BigInteger은 문자열이기에 사칙연산이 안된다. 그렇기에 BigIntger 내부의 숫자를 계산하기 위해서는 BigIntger 클래스 내부에 있는 메서드를 사용해야 한다.
BigInteger bigNumber1 = new BigInteger("100000");
BigInteger bigNumber2 = new BigInteger("10000");

System.out.println("덧셈(+) :" +bigNumber1.add(bigNumber2));
System.out.println("뺄셈(-) :" +bigNumber1.subtract(bigNumber2));
System.out.println("곱셈(*) :" +bigNumber1.multiply(bigNumber2));
System.out.println("나눗셈(/) :" +bigNumber1.divide(bigNumber2));
System.out.println("나머지(%) :" +bigNumber1.remainder(bigNumber2));
 */