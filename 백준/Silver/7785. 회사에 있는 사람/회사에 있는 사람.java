import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<String, String> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String inout = st.nextToken();

            if(inout.equals("enter"))
                map.put(name, inout);
            else if(inout.equals("leave"))
                map.remove(name);
        }

        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, Collections.reverseOrder());

        for (String key: keyList) {
            System.out.println(key);
        }
    }
}