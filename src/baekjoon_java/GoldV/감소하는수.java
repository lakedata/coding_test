package baekjoon_java.GoldV;

import java.io.*;
import java.util.*;

public class 감소하는수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Long> nums = new ArrayList<>();

        for (int i = 1; i < 1024; i++) {
            nums.add(convert(i));
        }

        Collections.sort(nums);
        if (N >= 1023) System.out.println(-1);
        else System.out.println(nums.get(N));
    }


    static long convert(int mask) {
        long ret = 0;
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            if ((mask & (1<<i)) != 0) {
                ret += (i * (long) Math.pow(10, cnt++));
            }
        }
        return ret;
    }
}
