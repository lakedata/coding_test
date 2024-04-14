package baekjoon_java.SilverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1929_소수구하기 { //문제유형: 에라토스테네스의 체 , 메모리 제한: 256MB, 시간 제한: 2초
    static boolean[] isPrime;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        isPrime_fun(N);
        for (int i = M; i <= N; i++) {
            if(!isPrime[i]) System.out.println(i);
        }
    }

    // 에라토스테네스의 체 알고리즘
    static void isPrime_fun(int n) {
        // true = 소수 아님, false = 소수
        isPrime = new boolean[n + 1];

        isPrime[0] = isPrime[1] = true; // // 0과 1은 소수가 아니기 때문에 true

        for (int i = 2; i <= Math.sqrt(n); i++) {
            // 소수라면 뒤에 오는 코드를 스킵
            if(isPrime[i]) continue;

            // 2부터 배수에 해당하는 수를 true로 변환
            for(int j = i * i; j < isPrime.length; j = j+i) {
                isPrime[j] = true;
            }
        }
    }
}
