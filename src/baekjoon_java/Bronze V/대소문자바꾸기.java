import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 대소문자바꾸기 {
    public static void main(String[] args) throws Exception {
        //방법1
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        String result = "";
//
//        for(char x : str.toCharArray()) {
//            if(Character.isLowerCase(x)) {
//                result += Character.toUpperCase(x);
//            } else {
//                result += Character.toLowerCase(x);
//            }
//
//        }
//        System.out.println(result);

        //방법2

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        char c[] = str.toCharArray();

        for(int i = 0; i < str.length(); i++) { //출력
            if(c[i] >= 'A' && c[i] <= 'Z')//대문자
                c[i] = Character.toLowerCase(c[i]);//대문자->소문자
            else if(c[i] >= 'a' && c[i] <= 'z')//소문자
                c[i] = Character.toUpperCase(c[i]);//소문자->대문자
        }
        for(int i = 0; i < str.length(); i++) { //출력
           System.out.print(c[i]);
        }

        //방법3
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            // 대문자면 소문자로 바꾸기
//            if (Character.isUpperCase(c)) {
//                sb.append(Character.toLowerCase(c));
//            } else {
//                // 소문자면 대문자로 바꾸기
//                sb.append(Character.toUpperCase(c));
//            }
//        }
//        System.out.print(sb);
    }
}
/*
1.문자(char)
대문자(A-Z) : 65 - 90
소문자(a-z) : 97 - 122

2.문자열(String)
Character객체
toUpperCase():소문자->대문자
toLowerCase():대문자->소문자

StringBuilder
.append(): 문자열을 추가

String.length();
String.charAt(index);
String.toCharArray();

charAt 함수
String 타입의 데이터(문자열)에서 특정 문자를 char 타입으로 변환


 */