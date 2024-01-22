package baekjoon_java.SilverIII;

import java.io.*;

public class boj_1515_수이어쓰기 { //구현, 문자열, 브루트포스
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int result = 0;
        int index = 0;

        while (true) {
            result++;
            String resString = Integer.toString(result); //현재 기준의 N
            for (int i = 0; i < resString.length(); i++) {
                if (resString.charAt(i) == str.charAt(index))
                    index++;
                if (index == str.length()) {
                    System.out.println(result);
                    return;
                }
            }
        }

    }

}
