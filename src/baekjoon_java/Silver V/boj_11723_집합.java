import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_11723_집합 {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder("");

        Set<Integer> set = new HashSet<>();

        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                set.add(x);
            }
            if (str.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                set.remove(x);
            }
            if (str.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                if (set.contains(x))
                    sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }
            if (str.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                if (set.contains(x))
                    set.remove(x);
                else
                    set.add(x);
            }
            if (str.equals("all")) {
                set.clear();
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            }
            if (str.equals("empty")) {
                set.clear();
            }
        }
        System.out.println(sb.toString());
    }

}
