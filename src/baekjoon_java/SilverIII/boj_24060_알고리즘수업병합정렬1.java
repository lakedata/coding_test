package baekjoon_java.SilverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_24060_알고리즘수업병합정렬1 {
    static int[] A;
    static int[] tmp; //정렬 후 저장하는 배열
    static int result = -1; //결과 저장 (실패시 -1)
    static int cnt = 0; //저장 횟수 누적 저장
    static int K; // 저장 횟수


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        tmp = new int[N];
        merge_sort(A, 0, N - 1);

        System.out.println(result);
    }

    public static void merge_sort(int[] A, int p, int r) {
        if(cnt > K) return; //저장 횟수가 진행 횟수보다 넘어가게 되면 더이상 분해 or 병합 진행X

        if (p < r) {
            int q = (p + r) / 2;       // q는 p, r의 중간 지점
            merge_sort(A, p, q);     // 전반부 정렬
            merge_sort(A, q + 1, r); // 후반부 정렬
            merge(A, p, q, r);        // 병합
        }
    }

    // A[p..q]와 A[q+1..r]을 병합하여 A[p..r]을 오름차순 정렬된 상태로 만든다.
    // A[p..q]와 A[q+1..r]은 이미 오름차순으로 정렬되어 있다.
    public static void merge(int A[], int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;// 배열은 0부터 시작

        while (i <= q && j <= r) {
            if (A[i] <= A[j])
                tmp[t++] = A[i++]; // tmp[t] <- A[i]; t++; i++;
            else
                tmp[t++] = A[j++]; // tmp[t] <- A[j]; t++; j++;
        }
        while (i <= q) {  // 왼쪽 배열 부분이 남은 경우
            tmp[t++] = A[i++];
        }
        while (j <= r)  // 오른쪽 배열 부분이 남은 경우
            tmp[t++] = A[j++];

        i = p;
        t = 0;
        while (i <= r) { // 결과를 A[p..r]에 저장
            cnt++;

            if(cnt == K) {
                result = tmp[t];
                break;
            }
            A[i++] = tmp[t++];
        }
    }

}
