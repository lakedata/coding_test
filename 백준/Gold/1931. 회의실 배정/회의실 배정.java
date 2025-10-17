import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] meeting = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());//시작
            meeting[i][1] = Integer.parseInt(st.nextToken());//끝
        }
        
        Arrays.sort(meeting, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        /*Arrays.sort(meeting, (a, b) -> {
            if (a[1] == b[1])
                return a[0] - b[0]; // 종료 시간 같으면 시작 시간 오름차순
            return a[1] - b[1]; // 종료 시간 오름차순
        });*/
        
        int count = 0;
        int end = 0;
        for(int i = 0; i < N; i++) {
            if( meeting[i][0] >= end) { //시작 시간이 이전 종료시간보다 크거나 같으면 진입
                end = meeting[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}