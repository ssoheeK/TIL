package Programmers.level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 각 조각에 동일한 가짓수의 토핑이 올라가면 공평하게 롤 케이크가 나눠진 것으로 생각한다.
public class RollCake {
    static class Solution {
        public int solution(int[] topping) {
            int answer = 0;
            // 공평하게 들어갔는지 확인할 set이 필요하다.
            Set<Integer> set = new HashSet<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < topping.length; i++) {
                map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
            }

            for (int i = 0; i < topping.length; i++) {
                set.add(topping[i]);

                if (map.get(topping[i]) == 1) {
                    map.remove(topping[i]);
                } else {
                    map.put(topping[i], map.get(topping[i]) - 1);
                }

                if (set.size() == map.size()) {
                    answer++;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
    }
}
