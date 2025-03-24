import java.util.*;

class Solution {
    
    // 소수 판별 함수
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(String numbers) {
        Set<Integer> primes = new HashSet<>();

        // 모든 숫자 조합을 생성
        for (int i = 1; i <= numbers.length(); i++) {
            permute(numbers, "", i, primes);
        }

        // 소수 개수 반환
        return primes.size();
    }

    // 숫자 순열을 생성하는 함수
    public void permute(String str, String current, int length, Set<Integer> primes) {
        if (current.length() == length) {
            int num = Integer.parseInt(current);
            // 소수인지 체크하고, 소수라면 Set에 추가
            if (isPrime(num)) {
                primes.add(num);
            }
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            permute(str.substring(0, i) + str.substring(i + 1), current + str.charAt(i), length, primes);
        }
    }
}