package Programmers.level2;

import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";

        int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        answer += arr[0] + " " + arr[arr.length - 1];

        return answer;
    }
}

public class MaxAndMin {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("-1 -2 -3 -4"));
    }
}
