import java.util.*;

class Solution {
    static final int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] Board;
    int N, M;
    
    int calc(int arow, int acol, int brow, int bcol) {
        if(Board[arow][acol] == 0) return 0;
        Board[arow][acol] = 0; //1->0변경
        
        int ret = 0;
        for(int i = 0; i < 4; i++) {
            int nr = arow + D[i][0], nc = acol + D[i][1];
            if(nr < 0 || nr > N - 1 || nc < 0 || nc > M - 1) continue;
            if(Board[nr][nc] == 0) continue;
            
            int cnt = 1 + calc(brow, bcol, nr, nc);
            
            if(ret % 2 == 0) { //지는 경우(짝수)
                if(cnt % 2 == 0) {
                    ret = Math.max(ret, cnt); // 지는 수 중에서는 오래 버티는 수를 고름
                } else {  //이기는 수(홀수)를 찾으면 바로 그걸 선택
                    ret = cnt; 
                }
            } else { //이기는 수(홀수)
                if(cnt % 2 == 1) { 
                    ret = Math.min(ret, cnt);//이기는 수 중 가장 빨리 이기는 수를 고름
                }
            }
        }
        Board[arow][acol] = 1;
        return ret;
    }
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        Board = board;
        N = board.length;
        M = board[0].length;
        
        return calc(aloc[0], aloc[1], bloc[0], bloc[1]);
    }
}