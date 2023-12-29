package baekjoon_java.SilverIV;

import java.io.*;

public class boj_20125_쿠키의신체측정 {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '*') {
                    y = i + 2;
                    x = j + 1;
                    flag = true;
                    break;
                }
            }
            if (flag == true)    break;
        }

        int[] size = new int[5];

        for (int i = 0; i < x - 1; i++) {
            if (arr[y - 1][i] == '*')  size[0]++;
        }

        for (int i = x; i < n; i++) {
            if (arr[y - 1][i] == '*')  size[1]++;
        }

        for (int i = y; i < n; i++) {
            if (arr[i][x - 1] == '*')  size[2]++;
        }

        for (int i = y; i < n; i++) {
            if (arr[i][x - 2]  == '*')  size[3]++;
        }

        for (int i = y; i < n; i++) {
            if (arr[i][x]  == '*')  size[4]++;
        }

        bw.write(y + " " + x + "\n");
        bw.write(size[0] + " " + size[1] + " " + size[2] + " " + size[3] + " " + size[4]);

        bw.flush();
        bw.close();
        br.close();
    }
}
