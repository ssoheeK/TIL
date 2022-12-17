package Programmers.level1;

import java.util.Arrays;

public class 과일장수 {
    static class Solution {
        public int solution(int k, int m, int[] score) {
            int answer = 0;

            Arrays.sort(score);
            for (int i = score.length; i >= m; i-=m) {
                answer += score[i - m] * m;
            }
            
            return answer;
        }
    }

    public static void main(String[] args) {
        int[] score = {1, 2, 3, 1, 2, 3, 1};
        System.out.println(new Solution().solution(3, 4, score));
    }
}
