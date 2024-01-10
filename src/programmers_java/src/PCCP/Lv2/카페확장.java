package PCCP.Lv2;

import java.util.*;

public class 카페확장 { //구현, 시뮬레이션, 큐
    private final int MAX_TIME = 1000500;
    private int[] wait = new int[MAX_TIME];

    public int solution(int[] menu, int[] order, int k) {
        int answer = 0;
        int menuEndTime = 0;

        for (int i = 0; i < order.length; i++) {
            int enterTime = i * k;//입장시간
            int menuMakeTime = menu[order[i]];
            menuEndTime = Math.max(enterTime + menuMakeTime, menuEndTime + menuMakeTime);

            for(int j = enterTime; j < menuEndTime; j++) {
                wait[j]++;
            }
        }

        for(int i = 0; i < MAX_TIME; i++) {
            answer = Math.max(answer, wait[i]);
        }

        return answer;
    }
}
