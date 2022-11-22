package Programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class 할인행사 {
    static class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;

            /*Map<String, Integer> map = new HashMap<>();
            Map<String, Integer> basket = new HashMap<>();
            for (int i = 0; i < want.length; i++) {
                map.put(want[i], number[i]);
                basket.put(want[i], 0);
            }

            int index = 0;
            int nowIndex = 0;
            int len = 0;
            while (true) {
                if (basket.equals(map)) {
                    answer++;
                }

                if (nowIndex == discount.length) {
                    break;
                }

                // 10일 동안의 제품을 모두 확인했으면 이전 index의 제품은 지워준다.
                if (len == 10) {
                    basket.put(discount[index], basket.get(discount[index]) - 1);
                    index++;
                    len -= 1;
                    continue;
                }

                // 현재 인덱스에서 원하는 제품이 아니면 다음 인덱스로 넘어감
                if (!map.containsKey(discount[index])) {
                    index++;
                    nowIndex++;
                    continue;
                }

                // 현재 인덱스부터 10일동안의 할인 제품 목록을 확인한다.
                if (map.containsKey(discount[nowIndex])) {
                    basket.put(discount[nowIndex], basket.get(discount[nowIndex]) + 1);
                    nowIndex++;
                    len++;
                }
            }*/
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < want.length; i++) {
                map.put(want[i], number[i]);
            }

            for (int i = 0; i <= discount.length - 10; i++) {
                Map<String, Integer> basket = new HashMap<>();
                for (int j = 0; j < 10; j++) {
                    String item = discount[i + j];
                    basket.put(item, basket.getOrDefault(item, 0) + 1);
                }
                if (basket.equals(map)) {
                    answer++;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(new Solution().solution(want, number, discount));
    }
}
