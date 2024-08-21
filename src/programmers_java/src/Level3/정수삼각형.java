package Level3;

public class 정수삼각형 { //문제유형: 동적계획법(Dynamic Programming)
    public int solution(int[][] triangle) {
        int answer = 0;
        int height = triangle.length;
        int [][]dp = new int[height][height];

        //왼쪽
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < height; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
        }


        for(int i = 1; i < height; i++) {
            for(int j = 1; j <= i; j++) { // 삼각형 형태의 배열 구조로 i까지
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
            }
        }

        //마지막 줄에서 가장 높은 값
        for(int i = 0 ; i < height; i++) {
            answer = Math.max(dp[height - 1][i], answer);
        }

        return answer;
    }
}
