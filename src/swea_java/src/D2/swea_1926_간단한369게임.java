package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class swea_1926_간단한369게임 {
    static int N;

    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        for(int i= 1; i <= N; i++) {
            String tmp = String.valueOf(i);

            if(tmp.contains("3") == true || tmp.contains("6") == true || tmp.contains("9")) {
                for(int j = 0; j < tmp.length(); j++) {
                    tmp = tmp.replaceAll("[369]", "-");
                }
                tmp = tmp.replaceAll("[0124578]", "");
            }
            System.out.print(tmp + " ");
        }
    }
}
