package Programmers.level2;

import java.util.Arrays;

public class MaxAndMin {

    static class Solution {
        public String solution(String s) {
            String answer = "";

            int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(arr);

            answer += arr[0] + " " + arr[arr.length - 1];

            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("-1 -2 -3 -4"));
    }
}
