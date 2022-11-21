package Programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class 연속부분수열합의개수 {
    static class Solution {
        public int solution(int[] elements) {
            Set<Integer> set = new HashSet<>();

            int len = 0;
            int nowIndex = 0;
            int index = 0;
            int sum = 0;
            while (true) {
                // 인덱스 0부터 1씩 증가해 가면서 수를 더한다.
                // len 만큼 다 돌았다면 인덱스를 1증가하여 다음 인덱스로 넘어간다.
                // 마지막 인덱스이고, len 만큼 다 돌았다면 종료한다.
                if (len == elements.length && index == elements.length - 1) {
                    break;
                }

                if (len == elements.length) {
                    sum = 0;
                    len = 0;
                    index += 1;
                    nowIndex = index;
                }

                // 인덱스가 범위를 벗어났다면 0으로 세팅해준다.
                if (nowIndex > elements.length - 1) {
                    nowIndex = 0;
                }

                sum += elements[nowIndex++];
                set.add(sum);
                len += 1;
            }

            return set.size();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{7, 9, 1, 1, 4}));
    }
}
