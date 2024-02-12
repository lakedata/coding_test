package baekjoon_java.SilverⅡ;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_3758_KCPC {
    static class Team {
        int id;
        int[] scoreList;
        int submitNum;
        int lastSubmit;
        int totalScore;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int T = 0; T < testCase; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());   // 팀 개수
            int k = Integer.parseInt(st.nextToken());   // 문제 개수
            int t = Integer.parseInt(st.nextToken());  // 나의 팀 아이디
            int m = Integer.parseInt(st.nextToken());   // 로그 개수

            Team[] list = new Team[n];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int teamID = Integer.parseInt(st.nextToken());
                int problemNum = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                if (list[teamID - 1] == null) {
                    list[teamID - 1] = new Team();
                    list[teamID - 1].id = teamID;
                    list[teamID - 1].scoreList = new int[k + 1];
                }

                list[teamID - 1].scoreList[problemNum] = Math.max(score, list[teamID - 1].scoreList[problemNum]);
                list[teamID - 1].submitNum++;
                list[teamID - 1].lastSubmit = i;
            }
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    sum += list[i].scoreList[j];
                }
                list[i].totalScore = sum;
            }
            Arrays.sort(list, new Comparator<Team>() {

                @Override
                public int compare(Team o1, Team o2) {
                    // TODO Auto-generated method stub
                    if (o1.totalScore == o2.totalScore) {
                        if (o1.submitNum == o2.submitNum) {
                            // 제출횟수는 적은게 좋다.
                            return o1.lastSubmit - o2.lastSubmit;
                        }
                        return o1.submitNum - o2.submitNum;
                    }
                    return o2.totalScore - o1.totalScore;// 점수는 높은게 좋다.
                }
            });
            for (int i = 0; i < n; i++) {
                if (list[i].id == t) {
                    // 내 팀 찾음
                    bw.append(String.valueOf(i + 1) + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
