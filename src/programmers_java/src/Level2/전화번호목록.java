package Level2;

import java.util.*;

public class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);
        int size = phone_book.length - 1;

        for (int i = 0; i < size; i++) {
            String str1 = phone_book[i];
            String str2 = phone_book[i + 1];

            if (str2.startsWith(str1))
                answer = false;
        }
        return answer;
    }
}
