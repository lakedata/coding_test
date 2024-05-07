package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1206_View {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine()); // 건물의 개수
            int[] build = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                build[i] = Integer.parseInt(st.nextToken()); // 건물의 높이
            }

            int result = 0;
            for (int i = 2; i < N - 2; i++) { // 2 ~ N-2
                int maxRight = Math.max(build[i + 1], build[i + 2]); // 오른쪽 2개
                int maxLeft = Math.max(build[i - 1], build[i - 2]); // 왼쪽 2개
                int currentBuilding = build[i];

                int maxHeight = Math.max(maxLeft, maxRight);

                if (currentBuilding > maxHeight) {
                    result += currentBuilding - maxHeight;
                }
            }
            System.out.println("#" + test_case + " " + result);
        }
    }
}
