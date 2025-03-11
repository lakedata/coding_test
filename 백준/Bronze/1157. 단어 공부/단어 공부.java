import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();
       
        int count[] = new int[26];
        for(int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - 'A';
            count[num]++;
        }
        
        //단어 최댓값 체크
        int max = 0;
        char ch = '?';
        for(int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                ch = (char) (i + 'A');
            } else if (count[i] == max) {
                ch = '?';
            }
        }
        System.out.println(ch);
    }
}