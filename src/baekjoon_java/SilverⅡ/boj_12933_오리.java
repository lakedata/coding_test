package baekjoon_java.SilverⅡ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_12933_오리 {
    public static char[] QUACK = {'q', 'u', 'a', 'c', 'k'};
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        int remain = arr.length;
        int cnt = 0;
        while(remain != 0) {
            int pt = 0;
            int idx = 0;
            boolean chk = false;
            int []tmp = new int[5];
            while(idx < arr.length) {
                if(arr[idx] == QUACK[pt]) {
                    tmp[pt++] = idx;
                    if(pt == 5) {
                        chk = true;
                        remain -= 5;
                        pt = 0;
                        for(int i = 0; i < 5; i++) arr[tmp[i]] = '\0';
                    }
                }
                idx++;
            }
            if(chk) cnt++;
            else break;
        }
        System.out.println(remain == 0? cnt:-1);
    }
}
