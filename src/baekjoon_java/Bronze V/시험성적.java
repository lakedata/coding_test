import java.util.Scanner;

/*9498번
메모리 17712KB, 시간 212ms
*/
public class 시험성적 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int A = in.nextInt();
        in.close();

        System.out.print((A >= 90) ? "A" : (A >= 80) ? "B" : (A >= 70) ? "C" : (A >= 60) ? "D" : "F");
    }
}