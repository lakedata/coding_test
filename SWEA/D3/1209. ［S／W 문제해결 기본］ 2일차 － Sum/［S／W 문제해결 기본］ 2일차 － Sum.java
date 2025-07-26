import java.util.Scanner;

public class Solution {
    	public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int t = sc.nextInt(); 
            int[][] arr = new int[100][100];
            
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int maxSum = 0;

            // 행, 열 합 
            for (int i = 0; i < 100; i++) {
                int rowSum = 0;
                int colSum = 0;
                for (int j = 0; j < 100; j++) {
                    rowSum += arr[i][j];
                    colSum += arr[j][i];
                }
                maxSum = Math.max(maxSum, Math.max(rowSum, colSum));
            }

            // 대각선 합
            int d1 = 0, d2 = 0;
            for (int i = 0; i < 100; i++) {
                d1 += arr[i][i];
                d2 += arr[i][99 - i];
            }
            maxSum = Math.max(maxSum, Math.max(d1, d2));

            System.out.println("#" + test_case + " " + maxSum);
        }
    }
}
