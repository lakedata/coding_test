class Solution {
    static int[] dx = {0, 0, -1, 1}; // up, down, left, right
    static int[] dy = {1, -1, 0, 0};
    static String[] directions = {"up", "down", "left", "right"};
    
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0, y = 0;
        int rangeX = board[0] / 2;
        int rangeY = board[1] / 2;
        
        for (String key : keyinput) {
            for (int i = 0; i < 4; i++) {
                if (key.equals(directions[i])) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= -rangeX && nx <= rangeX && ny >= -rangeY && ny <= rangeY) {
                        x = nx;
                        y = ny;
                    }
                    break;
                }
            }
        }
        
        return new int[] {x, y};
    }
}
