package baekjoon_java.BronzeII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
https://www.acmicpc.net/problem/19532
16052KB 276ms 브루트포스 알고리즘
*/
public class 수학은비대면강의입니다 {
    static int a,b,c,d,e,f;
    static int x,y;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());


        for(int i =-999; i <= 9999; i++) {
            for (int j = -999; j <= 9999; j++) {
                if((a * i) + (b * j) == c && ((d * i) + (e * j) == f)) {
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(x + " " + y);
    }
}
