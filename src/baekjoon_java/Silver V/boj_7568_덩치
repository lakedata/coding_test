import java.io.*;
import java.util.*;

public class boj_7568_덩치 {

	static int [][]person;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

        int[][] person = new int[n + 1][2];

		
		for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

			person[i][0] = Integer.parseInt(st.nextToken());
			person[i][1] = Integer.parseInt(st.nextToken());
	
		}
		  int rank;
	        // 동점을 고려한 순위를 매기는 논리
	        for (int i = 1; i <= n; i++) {
	            rank = 1;
	            for (int j = 1; j <= n; j++) {
	                if (i != j) {
	                    if ((person[i][0] < person[j][0] && person[i][1] < person[j][1]))
	                        rank++;
	                    }
	                }
	            System.out.print(rank + " ");
	        }

	}
}
