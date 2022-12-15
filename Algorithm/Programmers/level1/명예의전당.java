package Programmers.level1;

import java.util.PriorityQueue;

public class 명예의전당 {
    static class Solution {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i < score.length; i++) {
                if (queue.size() < k) {
                    queue.add(score[i]);
                } else {
                    if (queue.peek() < score[i]) {
                        queue.poll();
                        queue.add(score[i]);
                    }
                }

                answer[i] = queue.peek();
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        System.out.println(new Solution().solution(3, score));
    }
}
