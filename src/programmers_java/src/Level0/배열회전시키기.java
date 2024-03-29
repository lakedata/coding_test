package Level0;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class 배열회전시키기 {
    public int[] solution(int[] numbers, String direction) {

        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());


        if(direction.equals("right")) {
            list.add(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
        } else if(direction.equals("left")) {
            list.add(list.size(), list.get(0));
            list.remove(0);
        }
        return list.stream().mapToInt(Integer::intValue).toArray(); //int 배열로
    }
}
