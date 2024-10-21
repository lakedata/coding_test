package baekjoon_java.BronzeII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1152_단어의개수 {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] sp = str.split(" ");

        int count = sp.length;
        if(str.equals(" "))
            count = 0;
        else if(sp[0].equals(""))
            count -= 1;
        System.out.println(count);
    }
}
