package baekjoon_java.GoldV;

import java.util.Scanner;

public class boj_11729_하노이탑이동순서 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        sb.append((int) (Math.pow(2, N) - 1)).append('\n');

        Hanoi(N, 1, 2, 3);
        System.out.println(sb);
    }

    /*
        N : 원판의 개수
        start : 출발지
        mid : 옮기기 위해 이동해야 장소
        to : 목적지
     */
    public static void Hanoi(int N, int start, int mid, int to) {
        if (N == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }
        Hanoi(N - 1, start, to, mid);
        sb.append(start + " " + to + "\n");

        Hanoi(N - 1, mid, start, to);
    }
}