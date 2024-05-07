package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1204_최빈수구하기 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] student = new int[1000];
            int[] count = new int[1000];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 1000; i++) {
                student[i] = Integer.parseInt(st.nextToken());
                count[student[i]]++;
            }

            int max = 0, index = 0;
            for (int i = 1000 - 1; i >= 0; i--) {
                if(max < count[i]) {
                    max = count[i];
                    index = i;
                }
            }

            System.out.println("#" + N + " " + index);
        }
    }
}
