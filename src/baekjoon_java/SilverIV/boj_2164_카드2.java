package baekjoon_java.SilverIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_2164_카드2 {
    static Queue<Integer>  qu = new LinkedList<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            qu.add(i);
        }

        while (qu.size() > 1) {
            qu.remove();     // 첫 번째 원소 제거
            qu.add(qu.poll());       // 첫 번째 원소 추가/제거
        }
        System.out.println(qu.peek()); //첫 번째 원소 반환
    }

}
