package Programmers.level2;

import java.util.Enumeration;

public class RepresentationByNumber {
    static class Solution {
        public int solution(int n) {
            int count = 1;

            for (int i = 1; i <= n / 2; i++) {
                int sum = i;
                for (int j = i + 1; sum < n; j++) {
                    sum += j;
                }
                if (sum == n) count++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(15));
    }
}
