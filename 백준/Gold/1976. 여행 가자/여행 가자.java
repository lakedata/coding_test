import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //유형: 그래프 , 메모리제한: 128MB, 시간 제한: 2초
    static int n, m;
    static int[] parents;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); // 도시 수
        m = Integer.parseInt(br.readLine()); // 여행 계획 속한 도시
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) parents[i] = i;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) union(i, j);  // 1 : 연결, 0 : 연결X
            }
        }

        String res = "YES";
        st = new StringTokenizer(br.readLine());
        int parent = Integer.parseInt(st.nextToken());
        for (int i = 1; i < m; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (find(parent) != find(now)) {
                res = "NO";
                break;
            }
        }
        System.out.println(res);
    }

    //x의 집합 찾기 : x의 대표자 찾기
    private static int find(int x) {
        if (parents[x] == x) return x; // 현재 노드의 부모가 존재하지 않는경우(현재 노드가 루트노드) 자기 자신 반환
        return parents[x] = find(parents[x]); // 현재 노드의 부모 노드가 존재한다면 재귀를 통해 루트노드를 찾아 반환
    }

    //x, y 두 집합 합치기 - 부모 노드(루트 노드) 가 같다면 두 노드의 부모 노드를 같게 만든다.
    private static void union(int x, int y) {
        int p1 = find(x);
        int p2 = find(y);

        if (x == y) return; // x와 y의 부모 노드가 같다면 두 노드는 연결되어 있다.

        // 부모 노드와 같게 만드는 union 작업
        if (p1 < p2) {  //더 작은(우선순위가 높은) 노드를 부모 노드로 선정한다.
            parents[p1] = p2;
        } else {
            parents[p2] = p1;
        }
    }
}
