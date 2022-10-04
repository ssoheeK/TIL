package Programmers.level2;

import java.util.Arrays;

public class Min {

    static class Solution {
        public int solution(int []A, int []B) {
            int answer = 0;

            Arrays.sort(A);
            Arrays.sort(B);

            int len = A.length;
            for (int i = 0; i < len; i++) {
                answer += (A[i] * B[len - 1 - i]);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        System.out.println(new Solution().solution(A, B));
    }
}
