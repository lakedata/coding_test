package baekjoon_java.GoldV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_7490_0만들기 {  //유형: 브루트포스 / 백트래킹 , 메모리제한: 128 MB, 시간 제한: 1초
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int number;
        for (int i = 0; i < T; i++) {
            number = Integer.parseInt(br.readLine());
            BF(number, 1, 1, 1, 0, "1");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void BF(int max, int now, int num, int sign, int sum, String str) {
        if (max == now) {
            sum = sum + (num * sign);
            if (sum == 0) {
                sb.append(str + "\n");
            }
            return;
        }
        BF(max, now + 1, num * 10 + (now + 1), sign, sum, str + " " + String.valueOf(now + 1));
        BF(max, now + 1, now + 1, 1, sum + (num * sign), str + "+" + String.valueOf(now + 1));
        BF(max, now + 1, now + 1, -1, sum + (num * sign), str + "-" + String.valueOf(now + 1));
    }
}
