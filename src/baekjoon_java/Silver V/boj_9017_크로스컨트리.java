import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_9017_크로스컨트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수 입력
        int T = Integer.parseInt(br.readLine());

        // 각 테스트 케이스 처리
        for (int testCase = 0; testCase < T; testCase++){
            // 참가자 수 입력
            int N = Integer.parseInt(br.readLine());
            int[] rank = new int[N];
            Map<Integer, Integer> result = new HashMap<>();

            // 참가자 순위 입력 및 데이터 처리
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++){
                int data = Integer.parseInt(st.nextToken());
                result.put(data, result.getOrDefault(data, 0) + 1);
                rank[i] = data;
            }

            // 추가 규칙에 따른 점수 부여
            int[] fifthGoalIdx = new int[result.size() + 1];
            Map<Integer, Integer> scoreMap = new HashMap<>();
            Map<Integer, Integer> tempMap = new HashMap<>();
            int score = 1;

            for (int element: rank){
                if (result.get(element) >= 6){
                    tempMap.put(element, tempMap.getOrDefault(element, 0) + 1);

                    if (tempMap.get(element) <= 4){
                        scoreMap.put(element, scoreMap.getOrDefault(element, 0) + score);
                    }

                    if (tempMap.get(element) == 5){
                        fifthGoalIdx[element] = score;
                    }
                    score++;
                }
            }

            // 결과를 정렬하여 출력
            List<Integer> keyData = new ArrayList<>(scoreMap.keySet());
            keyData.sort((x, y) -> {
                if (Objects.equals(scoreMap.get(x), scoreMap.get(y))){
                    return fifthGoalIdx[x] - fifthGoalIdx[y];
                } else{
                    return scoreMap.get(x) - scoreMap.get(y);
                }
            });
            System.out.println(keyData.get(0));
        }
    }
}