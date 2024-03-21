package Level2;

import java.util.*;

public class 쿼드압축후개수세기 {
    public int[] solution(int[][] arr) {
        answer = new int[2];
        divide(0, 0, arr.length, arr);

        return answer;
    }

    private static int[] answer;

    public void divide(int x, int y, int size, int[][] arr) {
        boolean isZero = true;
        boolean isOne = true;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] == 1)
                    isZero = false;
                if (arr[i][j] == 0)
                    isOne = false;
            }
        }

        if (isZero) {
            answer[0]++;
            return;
        } else if (isOne) {
            answer[1]++;
            return;
        }
        divide(x, y, size / 2, arr);
        divide(x, y + size / 2, size / 2, arr);
        divide(x + size / 2, y, size / 2, arr);
        divide(x + size / 2, y + size / 2, size / 2, arr);
    }
}
