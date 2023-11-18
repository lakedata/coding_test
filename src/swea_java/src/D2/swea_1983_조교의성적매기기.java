package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1983_조교의성적매기기 {
    static String[] scores = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); //사람수
            int K = Integer.parseInt(st.nextToken());//선택할 K

            double grade[] = new double[N + 1];
            int cnt = 0;

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                grade[i] = ((a * 0.35) + (b * 0.45) + (c * 0.2));
            }


            for (int i = 1; i <= N; i++) {
                if (grade[i] > grade[K])
                    cnt++;
            }

            System.out.println("#" + test_case + " " + scores[cnt / (N / 10)]);
        }
    }
}
