package baekjoon_java.GoldIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
https://www.acmicpc.net/problem/9663
백트래킹 14468KB 5296ms
*/
public class NQueen {
    public static int N;
    public static int[] board;
    static int count = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        board = new int[N];
        dfs(0);
        System.out.println(count);
    }
    public static void dfs(int depth) { // depth=열
        if(depth == N) { // 모든 조건을 통과한 경우
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            board[depth] = i; // 유망성 체크가 true일 경우, 가지치기를 하지 않고 계속해서 진행

            if(isPossibleCheck(depth))
                dfs(depth + 1); // 다음 자식 노드 방문을 위해 depth 1 증가시키면서 재귀호출
        }
    }
    public static boolean isPossibleCheck(int column) {// 유망성을 체크하는 메소드
        for (int i = 0; i < column; i++) {

            if (board[column] == board[i]) // 같은 행에 퀸
                return false;

            // 대각선 체크 - 열의 차와 행의 차가 같으면 대각선
            if (Math.abs(column - i) == Math.abs(board[column] - board[i]))
                return false;
        }

        return true;
    }
}
