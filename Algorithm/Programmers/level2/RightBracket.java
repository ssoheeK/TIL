package Programmers.level2;

import java.util.Stack;

public class RightBracket {

    static class Solution {
        boolean solution(String s) {

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push('(');
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }

            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("(()("));
    }
}
