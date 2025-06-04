import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[]P;
    static int[] S;
    static int[] cards;    
    static int[] originalCards;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        P = new int[N];
        for(int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        S = new int[N];
        for(int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        cards = new int[N];
        for(int i = 0; i < N; i++) {
            cards[i] = i;
        }
        originalCards = cards.clone();
    
        while(check() == false) {
            if (cnt != 0 && Arrays.equals(cards, originalCards)) {
                cnt = -1;
                break;
            }
            cnt += 1;
            shuffle();
        }
    
        System.out.println(cnt);
    }
    public static void shuffle() {
        int []tmp = new int[N];
        for(int i = 0; i < N; i++) {
           tmp[S[i]] = cards[i];
        }
        cards = tmp.clone();
    }
    public static boolean check() {
        for(int i = 0; i < N; i++) {
            if(P[cards[i]] != i%3) {
                return false;
            }
        }
        return true;
    }
}
