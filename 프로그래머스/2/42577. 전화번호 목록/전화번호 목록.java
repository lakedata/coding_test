import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);//문자열B의 접두사가 될 수 있는 문자열 A는 B앞에
        
        for(int i = 0; i < phone_book.length - 1; i++) {
            String str1 = phone_book[i];
            String str2 = phone_book[i + 1];
               
            if(str2.startsWith(str1))
                answer = false;
        }
        return answer;
    }
}