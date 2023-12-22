import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10431_줄세우기 {
    static int[] item = new int[20];
    static int count = 0;
    static int T;

    public static void main(String arg[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int P = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < P; tc++) {
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            T = Integer.parseInt(st.nextToken());
            for (int i = 0; i < 20; i++) {
                item[i] = Integer.parseInt(st.nextToken());
            }
            //System.out.println(Arrays.toString(item));
            insertionSort(item);
            System.out.println(T + " " + count);
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = i;

            for (int j = i - 1; j >= 0; j--) {
                if (array[key] < array[j]) {
                    swap(array, key, j);
                    key = j;
                }
            }
        }
    }

    public static void swap(int[] array, int source, int target) {
        int temp = array[source];
        array[source] = array[target];
        array[target] = temp;
        count += (source - target);
    }

}
