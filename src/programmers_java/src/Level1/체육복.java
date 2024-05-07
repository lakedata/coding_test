package Level1;

import java.util.*;

class 체육복 { // 탐욕법(Greedy)
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int student[] = new int[n+2];

        Arrays.sort(lost);
        Arrays.sort(reserve);

        Arrays.fill(student, 0);

        for(int l : lost) student[l]--;
        for(int r : reserve) student[r]++;

        for(int i = 1; i <= n; i++) {
            if(student[i] == -1)
                if(student[i-1] == 1) {
                    student[i]++;
                    student[i-1]--;
                }
                else if(student[i+1] == 1) {
                    student[i]++;
                    student[i+1]--;
                }
        }

        for(int i = 1; i <= n; i++) {
            if(student[i] != -1)
                answer++;
        }

        return answer;
    }
}
