package baekjoon_java.GoldIV;

import java.io.*;
import java.util.*;

public class boj_1753_최단경로 {
    static final int INF = (int) 1e9 + 10;
    static int v, e, start;
    static ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    static int[] d = new int[20005];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }

        Arrays.fill(d, 0, v + 1, INF);

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(u).add(new Pair(w, v));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));
        d[start] = 0;
        pq.offer(new Pair(0, start));

        while (!pq.isEmpty()) {
           Pair cur = pq.poll();
            int curCost = cur.cost;
            int curVertex = cur.vertex;

            if (d[curVertex] != curCost) continue;

            for (Pair nxt : adj.get(curVertex)) {
                if (d[nxt.vertex] > d[curVertex] + nxt.cost) {
                    d[nxt.vertex] = d[curVertex] + nxt.cost;
                    pq.offer(new Pair(d[nxt.vertex], nxt.vertex));
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= v; i++) {
            if (d[i] == INF) {
                bw.write("INF\n");
            } else {
                bw.write(d[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}

class Pair {
    int cost, vertex;

    Pair(int cost, int vertex) {
        this.cost = cost;
        this.vertex = vertex;
    }
}
