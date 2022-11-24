package Programmers.level2;

public class k진수에서소수개수구하기 {
    static class Solution {
        public int solution(int n, int k) {
            int answer = 0;

            // 437674를 3진수로 바꾸면 211020101011이다.
            StringBuilder convertNum = new StringBuilder();
            while (n > 0) {
                convertNum.append(n % k);
                n /= k;
            }
            convertNum = convertNum.reverse();

            int j;
            for (int i = 0; i < convertNum.length(); i = j) {
                for (j = i + 1; j < convertNum.length(); j++) {
                    if (convertNum.charAt(j) == '0') {
                        break;
                    }
                }
                if (checkDecimal(Long.parseLong(convertNum.substring(i, j)))) {
                    answer++;
                }
            }

            return answer;
        }
        private boolean checkDecimal(long number) {
            if (number < 2) return false;
            else if (number == 2) return true;

            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                } else {
                    continue;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(110011, 10));
    }
}
