import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, String> map = new HashMap<>();

        int N = Integer.parseInt(st.nextToken()); // 걸그룹 수
        int M = Integer.parseInt(st.nextToken()); // 문제 수
        String[] quiz = new String[M];

        //팀의 이름, 걸그룹의 인원 수, 멤버의 이름
        // 0 : 팀의 이름 -> 이름 사전 순, 1 : 멤버의 이름 -> 팀 이름
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            int count = Integer.parseInt(br.readLine());

            for (int j = 0; j < count; j++) {
                String person = br.readLine();
                map.put(person, name);
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        for (int i = 0; i < M; i++) {
            quiz[i] = br.readLine();
            int flag = Integer.parseInt(br.readLine());

            if (flag == 1) {
                System.out.println(map.get(quiz[i]));
            } else if (flag == 0) {
                for (String key : keySet) {
                    if (quiz[i].equals(map.get(key)))
                        System.out.println(key);
                }
            }
        }
    }
}
