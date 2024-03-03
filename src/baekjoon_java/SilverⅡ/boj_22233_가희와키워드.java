package baekjoon_java.SilverⅡ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_22233_가희와키워드 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        HashSet<String> hm = new HashSet<String>();

        for (int i = 0; i < N; i++) {
            hm.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()) {
                String key = st.nextToken();
                if (hm.contains(key))
                    hm.remove(key);
            }
            System.out.println(hm.size());
        }
    }
}
