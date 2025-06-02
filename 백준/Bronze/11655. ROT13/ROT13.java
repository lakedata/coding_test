import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String answer = "";
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch >= 'a' && ch <= 'z') {
                ch = (char) ((ch - 'a' + 13) % 26 + 'a'); 
            }else if(ch >= 'A' && ch <= 'Z') {
                ch = (char) ((ch - 'A' + 13) % 26 + 'A');  
            }
            answer += ch;
        }
        System.out.println(answer);
    }
}
