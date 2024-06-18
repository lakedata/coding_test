package Level1;

import java.util.*;
public class 포켓몬 { // 문제유형 : 해시
    public int solution(int[] nums) {
        int answer = nums.length / 2;

        HashSet<Integer> set = new HashSet<Integer>(); //HashSet생성

        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);

        if (answer > set.size())
            answer = set.size();

        return answer;
    }
}
