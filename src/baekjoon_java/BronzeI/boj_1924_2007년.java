package baekjoon_java.BronzeI;

import java.util.Scanner;

public class boj_1924_2007년 {
    private static String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    private static int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int sum = 0;
        for (int i = 0; i < x - 1; i++) {
            sum += month[i];
        }
        sum += y;
        System.out.println(day[sum % 7]);
    }
}
