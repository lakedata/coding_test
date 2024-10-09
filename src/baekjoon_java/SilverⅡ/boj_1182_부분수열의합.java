package baekjoon_java.SilverⅡ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1182_부분수열의합 {
    static int n; //정수의 갯수
    static int s; //정수의 합
    static int []arr = new int[40];
    static int cnt = 0;
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        func(0, 0);

        System.out.println(s == 0 ? cnt - 1 : cnt);
    }
    public static void func(int cur, int tot) {
        if(cur == n) {
            if(tot == s) cnt++;
            return;
        }
        // tree
        func(cur + 1, tot); // 원소를 선택하지 않았을 때
        func(cur + 1, tot + arr[cur]); // 원소를 선택
    }
}
