import java.io.*;
import java.util.*;

public class boj_8979_올림픽 {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] l = new int[n + 1][4];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()); // NUM
            l[idx][0] = idx;
            l[idx][1] = Integer.parseInt(st.nextToken()); // Gold
            l[idx][2] = Integer.parseInt(st.nextToken()); // Silver
            l[idx][3] = Integer.parseInt(st.nextToken()); // Bronze
        }

        int rank;
        // 동점을 고려한 순위를 매기는 논리
        for (int i = 1; i <= n; i++) {
            rank = 1;
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    if (l[i][1] < l[j][1] || (l[i][1] == l[j][1] && l[i][2] < l[j][2])
                            || (l[i][1] == l[j][1] && l[i][2] == l[j][2] && l[i][3] < l[j][3])) {
                        rank++;
                    }
                }
            }
            if (i == k) { // 지정된 국가 K의 등수를 찾은 후 종료
                System.out.println(rank);
                break; 
            }
        }
    }
}
