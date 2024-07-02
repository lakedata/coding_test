package baekjoon_java.GoldII;

import java.io.*;
import java.util.*;

public class 보석도둑 { //문제유형 : 그리디
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken()); // 보석
        int k = Integer.parseInt(st.nextToken()); // 가방

        int[] bag = new int[k];
        Jewel[] jewels = new Jewel[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(m, v);
        }

        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels);
        Arrays.sort(bag);

        //우선순위큐 내림 차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        long answer = 0;
        int j = 0;
        for (int i = 0; i < k; i++) {
            while (j < n) {
                if (bag[i] < jewels[j].weight) //다음 보석부터 가방의 무게보다 클 때
                    break;
                pq.add(jewels[j++].price); //가방에 보석을 넣을 수 있을 때
            }
            if (!pq.isEmpty())
                answer += pq.poll();
        }
        System.out.println(answer + " ");
    }
}

class Jewel implements Comparable<Jewel> {
    int weight;
    int price;

    public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Jewel o) {
        if (this.weight == o.weight)        //무게가 같을 때 가치 내림차순
            return o.price - this.price;
        return this.weight - o.weight;    //무게 오름차순
    }
}
