import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수

        // 보석(무게 오름차순 정렬 후 가격 내림차순 정렬)
        List<Pair> jewels = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 보석 무게
            int V = Integer.parseInt(st.nextToken()); // 보석 가격
            jewels.add(new Pair(M, V));
        }
        Collections.sort(jewels, Comparator.comparingInt((Pair p) -> p.x)); // 무게 오름차순 정렬

        // 가방 무게 배열 입력 및 정렬 (가방도 작은 것부터 처리)
        int[] C = new int[K];
        for (int i = 0; i < K; i++) {
            C[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(C);

        // 우선순위 큐: 가격이 높은 순으로 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0; 
        int index = 0;

        for (int i = 0; i < K; i++) {
            while (index < N && jewels.get(index).x <= C[i]) {
                pq.add(jewels.get(index).y);
                index++;
            }

            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }
        System.out.println(sum);
    }

    static class Pair {
        int x, y; // 무게, 가격
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}