package baekjoon_java.SilverIII;

import java.io.*;
import java.util.*;

public class boj_20920_영단어암기는괴로워 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        List<Word> list = new ArrayList<>();
        Map<String, Word> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String cur = br.readLine();

            if (cur.length() < m) continue;

            if (map.containsKey(cur)) {    // HashMap에 이미 존재한다면
                map.get(cur).count();    // 카운팅만 해준다.
                continue;
            }

            Word word = new Word(cur);    // HashMap에 없다면 객체를 생성하고
            list.add(word);    // 리스트와
            map.put(cur, word);    // HashMap에 넣어준다
        }
        Collections.sort(list);

        for (Word word : list) {
            sb.append(word.name).append('\n');
        }
        System.out.print(sb);
    }

    static class Word implements Comparable<Word> {
        String name;
        int cnt;

        public Word(String name) {
            this.name = name;
            cnt = 1;
        }

        public void count() {
            this.cnt++;
        }

        @Override
        public int compareTo(final Word o) {
            if (this.cnt != o.cnt) { // 1. 자주 나오는 단어일수록 앞에 배치
                return o.cnt - this.cnt;
            }

            if (this.name.length() != o.name.length()) { // 2. 해당 단어의 길이가 길수록 앞에 배치
                return o.name.length() - this.name.length();
            }

            return this.name.compareTo(o.name); // 3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치
        }
    }
}
