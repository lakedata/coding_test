import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_25757_임스와함께하는미니게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> set = new HashSet<>();

        int N = Integer.parseInt(st.nextToken());
        String K = st.nextToken();
        int num = 0;
        if (K.equals("Y")) num = 1;
        else if (K.equals("F")) num = 2;
        else if (K.equals("O")) num = 3;


        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        System.out.println(set.size() / num);
    }
}