package Level2;

import java.util.*;

public class 의상 { //문제유형: 해시
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(int i = 0; i < clothes.length; i++)  {
            String kind = clothes[i][1];

            if(map.containsKey(kind))
                map.put(kind, map.get(kind) + 1);
            else
                map.put(kind, 1);
        }

        int num = 1;
        for (String key : map.keySet()) {
            num  *=  (map.get(key) + 1);
            // System.out.print("Key : " + key);
            // System.out.println(", Val : " + map.get(key));
        }

        int answer = num - 1;
        return answer;
    }
}
