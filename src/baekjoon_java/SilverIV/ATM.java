package baekjoon_java.SilverIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {
    public static void main(String[] arg) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int atm[] = new int[N + 1];

        for (int i = 0; i < N; i++) {
            atm[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(atm);

        int sum = 0;
        int p[] = new int[N + 1];

        for (int i = 0; i < atm.length; i++) {
            if (i == 0)
                p[i] += atm[i];
            else
                p[i] += p[i - 1] + atm[i];

        }

        for (int i = 0; i < atm.length; i++) {
            sum += p[i];
        }

        System.out.println(sum);// 각 사람이 돈을 인출하는데 걸리는 시간
    }
}
