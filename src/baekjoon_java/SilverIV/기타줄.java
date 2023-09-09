package baekjoon_java.SilverIV;

import java.util.Arrays;
import java.util.Scanner;

public class 기타줄 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        // 끊어진 기타줄 수 N과 브랜드 M개 입력 받기
        int BrokenString = scanner.nextInt();
        int BrandNum = scanner.nextInt();

        // 브랜드 수만큼의 칸을 가진, 패키지 가격과 낱개 가격에 대한 배열 생성
        int[] packagePrice = new int[BrandNum];
        int[] unitPrice = new int[BrandNum];

        // i가 브랜드 수 즉 주어진 옵션만큼을 다 순회하는 반복문 사용
        for (int i = 0; i < BrandNum; i++) {
            // 들어오는 값을 순차적으로 패키지 가격 배열과 낱개 가격 배열에 추가
            packagePrice[i] = scanner.nextInt();
            unitPrice[i] = scanner.nextInt();
        }

        // 가장 싼 가격이 앞으로 오게 배열 오름차순 정렬
        Arrays.sort(packagePrice);
        Arrays.sort(unitPrice);

        // 답안 초기화
        int res = 0;

        //Math.min() 함수를 이용해
        // 1) 가장 싼 패키지 가격 vs. 가장 싼 낱개 가격
        // 2) 1)에서 더 적은 가격 vs. 패키지+낱개 혼합 구매 가격
        res = Math.min(((BrokenString / 6) + 1) * packagePrice[0], BrokenString * unitPrice[0]);
        res = Math.min(res, (BrokenString % 6) * unitPrice[0] + (BrokenString / 6) * packagePrice[0]);

        // 답안 출력
        System.out.println(res);

    }
}