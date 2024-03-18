package baekjoon_java.SilverⅡ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_20006_랭킨전대기열 { //구현
    public static class Player implements Comparable<Player> {
        int level;
        String name;
        boolean flag;

        Player(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player o) {
            return name.compareTo(o.name);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Player[] player = new Player[p];

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            player[i] = new Player(l, n);
        }

        for (int i = 0; i < p; i++) {
            ArrayList<Player> room = new ArrayList<>();
            if (!player[i].flag) {
                for (int j = i; j < p; j++) {
                    if (room.size() == m) {
                        break;
                    }
                    int level = player[j].level;
                    String name = player[j].name;
                    if (!player[j].flag && player[i].level - 10 <= level && player[i].level + 10 >= level) {
                        player[j].flag = true;
                        room.add(new Player(level, name));
                    }
                }
                Collections.sort(room);
                if (room.size() == m) {
                    sb.append("Started!").append("\n");
                } else {
                    sb.append("Waiting!").append("\n");
                }
                for (Player players : room) {
                    sb.append(players.level).append(" ").append(players.name).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
