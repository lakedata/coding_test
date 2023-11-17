package D2;
import java.io.*;
import java.util.*;

public class swea_1928_Base64Decoder {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            System.out.println("#" + test_case + " " + new String(Base64.getDecoder().decode(sc.nextLine())));
        }
    }

}