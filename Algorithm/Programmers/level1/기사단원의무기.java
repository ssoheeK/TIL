package Programmers.level1;

public class 기사단원의무기 {
    static class Solution {
        public int solution(int number, int limit, int power) {
            int sum = 0;

            for (int i = 1; i <= number; i++) {
                if (i == 1) {
                    sum += 1;
                    continue;
                } else if (i <= 3) {
                    sum += 2;
                    continue;
                }

                int count = 2; // 1과 자기자신
                for (int j = 2; j <= i/2; j++) {
                    if (i % j == 0) {
                        count++;
                    }
                }

                if (count > limit) {
                    count = power;
                }
                sum += count;
            }

            return sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(10, 3, 2));
    }
}
