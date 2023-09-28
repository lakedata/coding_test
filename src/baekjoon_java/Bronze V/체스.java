//킹, 퀸, 룩, 비숍, 나이트, 폰 3003번
import java.io.*;
import java.util.*;

public class 체스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] piece = {1, 1, 2, 2, 2, 8};  // 피스의 개수
        for (int i = 0; i < piece.length; i++) {
            int n = Integer.parseInt(st.nextToken());
            sb.append(piece[i] - n + " ");
        }
        System.out.print(sb);
    }
}
