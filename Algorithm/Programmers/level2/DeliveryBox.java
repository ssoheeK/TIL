package Programmers.level2;

import java.util.Stack;

public class DeliveryBox {
    static class Solution {
        public int solution(int[] orders) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();

            int num = 1;
            int index = 0;
            while (true) {
                if (index >= orders.length) {
                    break;
                }

                if (orders[index] == num) {
                    answer++;
                    num++;
                    index++;
                    continue;
                } else if (!stack.isEmpty() && stack.peek() == orders[index]) {
                    answer++;
                    index++;
                    stack.pop();
                    continue;
                }

                if (num > orders.length) {
                    break;
                }

                stack.push(num++);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{5, 4, 3, 2, 1}));
    }
}
