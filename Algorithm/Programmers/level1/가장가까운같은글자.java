package Programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 가장가까운같은글자 {
    static class Solution {
        public int[] solution(String s) {
            int[] answer = new int[s.length()];

            int value;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char alphabet = s.charAt(i);

                if (map.containsKey(alphabet)) {
                    value = i - map.get(alphabet);
                } else {
                    value = -1;
                }

                answer[i] = value;
                map.put(alphabet, i);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("banana"));
    }
}
