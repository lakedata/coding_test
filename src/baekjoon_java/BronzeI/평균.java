package baekjoon_java.BronzeI;

import java.io.*;
import java.util.*;

public class 평균 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        double sum = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            m = Math.max(m, num);  //시험 점수 최댓값 구하기
            sum += num;  //시험 점수 합에 더해주기
        }

        sum /= (double) m;  //시험 점수 최댓값으로 나눠주기
        sum *= 100.0;
        sum /= (double) n;  //평균 구하기
        System.out.print(sum);
    }
}

