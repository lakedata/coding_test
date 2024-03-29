package Level2;

public class 프론즈4블록 { //2018 KAKAO BLIND RECRUITMENT
    static char[][] blockMap;

    public static void main(String[] args) {
        System.out.println(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            int cnt = checkBlock(m, n, map);
            if (cnt == 0) break;
            answer += cnt;

            dropBlock(m, n, map);
        }

        return answer;
    }

    private static int checkBlock(int m, int n, char map[][]) {
        int cnt = 0;
        boolean[][] isChecked = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '.') continue;
                checkFour(map, isChecked, i, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isChecked[i][j]) {
                    cnt++;
                    map[i][j] = '.';
                }
            }
        }
        return cnt;
    }

    private static void checkFour(char[][] map, boolean[][] isChecked, int i, int j) {
        char block = map[i][j];

        if (i + 1 < map.length && j + 1 < map[0].length) {
            for (int r = i; r < i + 2; r++) { //블록이 같은지 체크
                for (int c = j; c < j + 2; c++) {
                    if (map[r][c] != block) return;
                }
            }
            for (int r = i; r < i + 2; r++) { //제거된 블록 표시
                for (int c = j; c < j + 2; c++) {
                    isChecked[r][c] = true;
                }
            }
        }
    }

    private static void dropBlock(int m, int n, char[][] map) {
        for (int c = 0; c < n; c++) { //열
            for (int r = m - 1; r >= 0; r--) { //행: 아래서 위로
                if (map[r][c] == '.') {
                    for (int nr = r - 1; nr >= 0; nr--) {
                        if (map[nr][c] != '.') {
                            map[r][c] = map[nr][c]; //위 쪽에서 블록 발견된거 옮김
                            map[nr][c] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}
