import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] tv = new String[n];
        int kbs1_idx = -1, kbs2_idx = -1;
        String result = "";
        
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            tv[i] = str;
            if (str.equals("KBS1")) {
                kbs1_idx = i;
            }
            if (str.equals("KBS2")) {
                kbs2_idx = i;
            }
        }
        
        if (kbs1_idx < kbs2_idx) {
            result = appendPattern(kbs1_idx, kbs2_idx, true);
        }
        else if (kbs1_idx > kbs2_idx) {
            result = appendPattern(kbs1_idx, kbs2_idx, false);
        }
        System.out.println(result);
    }
    
    private static String appendPattern(int kbs1_idx, int kbs2_idx, boolean isKbs1BeforeKbs2) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < kbs1_idx; i++) {
            sb.append("1");
        }
        for (int i = 0; i < kbs1_idx; i++) {
            sb.append("4");
        }

        if (isKbs1BeforeKbs2) {
            for (int i = 0; i < kbs2_idx; i++) {
                sb.append("1");
            }
            for (int i = 0; i < kbs2_idx - 1; i++) {
                sb.append("4");
            }
        }
        else {
            for (int i = 0; i < kbs2_idx + 1; i++) {
                sb.append("1");
            }
            for (int i = 0; i < kbs2_idx; i++) {
                sb.append("4");
            }
        }
        return sb.toString();
    }
}