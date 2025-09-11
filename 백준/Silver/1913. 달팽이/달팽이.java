import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        int []dx = {-1, 0, 1, 0}; //상 우 하 좌
        int []dy = {0, 1, 0, -1};
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int find = sc.nextInt();
        
        int [][]arr = new int[n][n];
        int value = 1, move = 1;
        int x = n / 2, y = n / 2;
        arr[x][y] = value;
        
        while (value < n * n) {
            for (int i = 0; i < 4 && value < n * n; i++) {
                for (int m = 0; m < move && value < n * n; m++) {
                    x += dx[i];
                    y += dy[i];
                    arr[x][y] = ++value;
                }
                if (i % 2 == 1) move++;   // 두 방향마다 증가
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int cx = 0, cy = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (find == arr[i][j]) {
                    cy = i + 1;
                    cx = j + 1;
                }
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(cy + " " + cx);
        System.out.println(sb.toString());
    }
}