package baekjoon_java.BronzeII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_3040_백설공주와일곱난쟁이 {
    static int[] dwarf = new int[9]; // 9명의 난쟁이
    static int[] arr = new int[7]; //  선택된 7명의 난쟁이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(dwarf);
        findDwarfs(0, 0, 0);
    }

    public static void findDwarfs(int depth, int start, int sum) {
        if (depth == 7) {
            if (sum == 100) {
                for (int i = 0; i < 7; i++) {
                    System.out.println(arr[i]);
                }
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            arr[depth] = dwarf[i];
            findDwarfs(depth + 1, i + 1, sum + dwarf[i]); // i + 1(중복 방지)
        }
    }
}
