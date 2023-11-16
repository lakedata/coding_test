package D2;
import java.util.*;
import java.io.*;

public class swea_1859_백만장자프로젝트 {
    static int price[];
    static int max;
    static long diff;
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            price = new int[N];
            max = 0;
            diff = 0;

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int i=0; i < N; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }
            for(int j=N-1; j >= 0; j--) {
                if(price[j] > max)
                    max = price[j];
                diff += max - price[j];
            }
            System.out.println("#" + test_case + " " + diff);
        }
    }
}
