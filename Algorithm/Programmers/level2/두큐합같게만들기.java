package Programmers.level2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 두큐합같게만들기 {
    static class Solution {
        public int solution(int[] queue1, int[] queue2) {
            Queue<Integer> q1 = new ArrayDeque<>();
            Queue<Integer> q2 = new ArrayDeque<>();

            for (int num: queue1) q1.add(num);
            for (int num: queue2) q2.add(num);

            long sum1 = Arrays.stream(queue1).sum();
            long sum2 = Arrays.stream(queue2).sum();
            long mid = sum1 + sum2;
            if (mid % 2 == 1) {
                return -1;
            }
            mid /= 2;
            int p1 = 0, p2 = 0, len = queue1.length * 2;
            while (p1 <= len && p2 <= len) {
                if (sum1 == mid) return p1 + p2;

                if (sum1 > mid) {
                    int num = q1.poll();
                    sum1 -= num;
                    sum2 += num;
                    q2.add(num);
                    p1++;
                } else {
                    int num = q2.poll();
                    sum1 += num;
                    sum2 -= num;
                    q1.add(num);
                    p2++;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        System.out.println(new Solution().solution(queue1, queue2));
    }
}
