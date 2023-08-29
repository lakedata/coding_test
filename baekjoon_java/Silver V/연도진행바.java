import java.util.Scanner;

public class 연도진행바 {
    static int[] Find_LeapYear(String string_year) {    //윤년을 판단할 메소드
        int year = Integer.parseInt(string_year);
        int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) month[2] = 29;
        return month;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split(" ");
        //tmp[0] = Month, tmp[1]=DD, , tmp[2]=YYYY, tmp[3]=HH:MM

        int[] monthArr = Find_LeapYear(tmp[2]);

        String[] month_name = {"0", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int month = 0;
        for (int i = 1; i < month_name.length; i++) {
            if (tmp[0].equals(month_name[i])) month = i;
        }

        int date = Integer.parseInt(tmp[1].substring(0, 2));

        String[] split = tmp[3].split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);

        //1월~해당 월 전월까지 일수 합하기
        int sum_date = 0;
        for (int i = 1; i < month; i++) {
            sum_date += monthArr[i];
        }
        sum_date += date - 1;

        //합한 일수를 분 단위로 전환
        sum_date = sum_date * 1440;

        //시간을 분으로 전환하기
        int sum_hour = hour * 60;

        //총 시간(분 단위)
        int Sum = sum_date + sum_hour + minute;


        if (monthArr[2] == 28) {
            System.out.println((double) Sum / (double) 525600 * 100);
        } else System.out.println((double) Sum / (double) 527040 * 100);


    }

}
