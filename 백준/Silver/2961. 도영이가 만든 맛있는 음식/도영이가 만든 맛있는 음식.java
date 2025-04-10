import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] taste;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        taste = new int[N][2]; // [0]은 신맛, [1]은 쓴맛

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            taste[i][0] = Integer.parseInt(st.nextToken()); // 신맛
            taste[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛
        }

        dfs(0, 1, 0, 0); // index, sour(곱), bitter(합), 사용한 재료 수

        System.out.println(minDiff);
    }

    static void dfs(int index, int sour, int bitter, int count) {
        if (index == N) {
            if (count > 0) { // 최소 한 개는 사용
                minDiff = Math.min(minDiff, Math.abs(sour - bitter));
            }
            return;
        }

        // 현재 재료를 사용하는 경우
        dfs(index + 1, sour * taste[index][0],  bitter + taste[index][1],  count + 1);

        // 현재 재료를 사용하지 않는 경우
        dfs(index + 1, sour, bitter, count);
    }
}