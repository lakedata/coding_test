package baekjoon_java.GoldIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1043_거짓말 { //유형: Union-Find, 메모리제한: 128MB, 시간 제한: 2초
    static int M, N;
    static int trueCnt;  //진실 아는 사람 수
    static int[] truePerson;  // 진실 아는 사람 번호

    static int comeCnt; // 파티 오는 사람 수
    public static ArrayList<Integer>[] comePerson; // 파티 오는 사람 번호

    static int[] parents;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사람 수
        M = Integer.parseInt(st.nextToken()); // 파티 수

        parents = new int[N + 1];
        for (int i = 0; i < N; i++) parents[i] = i;

        st = new StringTokenizer(br.readLine());
        trueCnt = Integer.parseInt(st.nextToken());

        truePerson = new int[trueCnt];
        for (int i = 0; i < trueCnt; i++) {
            truePerson[i] = Integer.parseInt(st.nextToken());
        }

        comePerson = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            comePerson[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            comeCnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < comeCnt; j++) {
                comePerson[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        solve();
    }

    static void solve() {
        for (int i = 0; i < M; i++) {
            int firstPerson = comePerson[i].get(0);
            for (int j = 1; j < comePerson[i].size(); j++) {
                union(firstPerson, comePerson[i].get(j));
            }
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            int leader = comePerson[i].get(0);
            boolean flag = true;
            for (int j = 0; j < trueCnt; j++) {
                if (find(leader) == find(truePerson[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }

        System.out.println(cnt);
    }

    static void union(int x, int y) {
        int p1 = find(x);
        int p2 = find(y);

        if (p1 != p2) parents[p2] = p1;
    }

    static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
}
