package baekjoon_java.SilverⅡ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2304_창고다각형 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] block = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            block[i][0] = Integer.parseInt(st.nextToken()); // 위치
            block[i][1] = Integer.parseInt(st.nextToken()); // 높이
        }

        // 위치를 기준으로 오름차순 정렬
        Arrays.sort(block, (o1, o2) -> o1[0] - o2[0]);

        Stack<Integer> stack = new Stack<>();
        int maxIndex = 0;

        // 가장 높은 블록 찾기
        for (int i = 1; i < N; i++) {
            if (block[i][1] > block[maxIndex][1]) {
                maxIndex = i;
            }
        }

        int sum = 0;
        // 왼쪽부터 가장 높은 블록까지의 넓이 계산
        for (int i = 0; i < maxIndex; i++) {
            if (stack.isEmpty() || block[i][1] > block[stack.peek()][1]) {
                stack.push(i);
            }
            sum += (block[i + 1][0] - block[i][0]) * block[stack.peek()][1];
        }

        stack.clear();
        // 오른쪽부터 가장 높은 블록까지의 넓이 계산
        for (int i = N - 1; i > maxIndex; i--) {
            if (stack.isEmpty() || block[i][1] > block[stack.peek()][1]) {
                stack.push(i);
            }
            sum += (block[i][0] - block[i - 1][0]) * block[stack.peek()][1];
        }

        // 가장 높은 블록의 넓이 더하기
        sum += block[maxIndex][1];

        System.out.println(sum);
    }
}
