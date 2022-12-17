package Programmers.level2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 귤고르기 {
    static class Solution {
        public int solution(int k, int[] tangerine) {
            int answer = 0;

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < tangerine.length; i++) {
                map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
            }

            List<Integer> list = new ArrayList<>(map.values());
            list.sort((s1, s2) -> s2 - s1);

            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                if (count >= k) {
                    break;
                }

                count += list.get(i);
                answer++;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }
}
