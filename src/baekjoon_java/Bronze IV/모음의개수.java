import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 모음의개수 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = bf.readLine();
            str = str.toLowerCase();//라인단위로 입력

            if (str.equals("#"))
                break;

            int ans=0;
            for(int i = 0; i < str.length(); i++) {
                char t = str.charAt(i);
                if(t =='a' || t =='e' || t =='i' || t =='o' || t =='u')
                    ans++;
            }
            System.out.println(ans);
        }
    }
}
