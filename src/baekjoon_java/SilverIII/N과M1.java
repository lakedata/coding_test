package baekjoon_java.SilverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*https://www.acmicpc.net/problem/15649
백트래킹 , 23396KB ,268ms*/
public class N과M1 {
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    public static int N;

    public static int M;

    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visit = new boolean[N];

        back(0);
        System.out.println(sb);
    }

    public static void back(int depth) {
        if (depth == M) {	// 재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열을 출력
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visit[i]) { // 만약 해당 노드(값)을 방문하지 않았다면?
                visit[i] = true; // 해당 노드를 방문상태로 변경
                arr[depth] = i + 1; // 해당 깊이를 index로 하여 i + 1 값 저장
                back(depth + 1); // 다음 자식 노드 방문을 위해 depth 1 증가시키면서 재귀호출
                visit[i] = false; // 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
            }
        }
    }
}
