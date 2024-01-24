package baekjoon_java.SilverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_19941_햄버거분배 { //그리디 알고리즘

    //사람의 위치-K~사람의 위치+K까지의 햄버거를 먹을 수 잇는데, 가장 왼쪽에 있는 햄버거를 먹는것이 다음 사람을 위해 좋은 선택이다.
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        boolean[] visit = new boolean[N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {
                for (int j = i - K; j <= i + K; j++) {
                    if (j >= 0 && j < N && arr[j] == 'H' && !visit[j]) {
                        visit[j] = true;
                        ++count;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
