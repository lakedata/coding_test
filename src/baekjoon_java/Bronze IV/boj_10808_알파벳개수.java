import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_10808_알파벳개수 {
    public static void main(String arg[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int []alpha = new int[26];

        Arrays.fill(alpha, 0);

        for(int i = 0; i < str.length(); i++)
            alpha[str.charAt(i) - 'a']++;

        for(int i = 0; i < alpha.length; i++)
            System.out.print(alpha[i] + " ");
    }
}
