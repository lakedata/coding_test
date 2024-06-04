package baekjoon_java.SilverIV;

import java.io.*;
import java.util.*;

public class boj_1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //1. hash에 듣도 못한 사람 반영
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i = 0; i < N; i++)
            hash.put(br.readLine(), 1); //1명

        //2. hash에 보도 못한 사람이 존재하는지 확인
        ArrayList<String> answer = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            String name = br.readLine();
            if(hash.containsKey(name))
                answer.add(name);
        }

        //3. 출력
        Collections.sort(answer);
        bw.write(answer.size() + "\n");
        for(int i = 0; i < answer.size(); i++) {
            bw.write(answer.get(i));
            bw.newLine();
        }
        bw.flush();

        bw.close();
        br.close();
    }
}
