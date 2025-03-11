import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 1; 
        int range = 1; 
        while (range < n) {
            range += count * 6;
            count++;
        }
        System.out.println(count);
    }
}