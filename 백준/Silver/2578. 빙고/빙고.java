import java.util.*;
import java.io.*;

class Main {
    static int [][]board = new int[5][5];
    static boolean [][]vis = new boolean[5][5];
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //빙고판 입력
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //사회자 숫자 하나씩 부름
        int num = 0;
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                num++;
                int input = Integer.parseInt(st.nextToken()); 
                checkNum(input);
                
                if(bingo() >= 3) {
    				System.out.println(num);
    				return;
    			}
            }
        }
    }
    
    public static void checkNum(int n) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(board[i][j] == n) {
                    vis[i][j] = true;
                    return;
                }
            }
        }
    }

    public static int bingo() {
        int count = 0; //3빙고
        int width = 0, height = 0;
        int index = 0;
        for(int i = 0; i < 5; i++) {
            width = 0;
            height = 0;
            for(int j = 0; j < 5; j++) {
                if(vis[i][j] == true) width++;
                if(vis[j][i] == true) height++;
            }
            if(width == 5) count += 1;
            if(height == 5) count += 1;
        }
    
        int xy = 0, yx = 0;
        for (int i = 0; i < 5; i++) {
            if (vis[i][i]) xy++;
            if (vis[i][4 - i]) yx++;
        }
        if(xy == 5) count += 1;
        if(yx == 5) count += 1;
        
        return count;
    }
}