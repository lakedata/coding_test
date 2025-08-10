import java.io.*;
import java.util.*;

public class Main {
    static final int INF = (int) 1e9 + 10;
    static int v, e, start, end;
    static ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    static int[] d = new int[20005];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());

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

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

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

        System.out.println(d[end]);
    }
}

class Pair {
    int cost, vertex;

    Pair(int cost, int vertex) {
        this.cost = cost;
        this.vertex = vertex;
    }
}