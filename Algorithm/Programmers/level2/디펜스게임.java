package Programmers.level2;

import java.util.PriorityQueue;
import java.util.Queue;

public class 디펜스게임 {
    static class Solution {
        public int solution(int n, int k, int[] enemy) {
            int answer = 0;

            Queue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i < enemy.length; i++) {
                queue.add(enemy[i]);

                if (queue.size() > k) {
                    n -= queue.poll();
                }

                if (n < 0) {
                    return i;
                }
            }
            return enemy.length;
        }
    }

    public static void main(String[] args) {
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};
        //int[] enemy = {3, 3, 3, 3};
        System.out.println(new Solution().solution(7, 3, enemy));
    }
}
