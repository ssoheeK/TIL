package Programmers.level2;

import java.util.*;

public class 주차요금계산 {
    static class Solution {

        public int[] solution(int[] fees, String[] records) {

            // 주차장의 요금표와 차량이 들어오고 나간 기록이 주어졌을 때 주차요금 계산
            Map<String, Integer> map = new TreeMap<>();
            int midnight = 23 * 60 + 59;
            for (int i = 0; i < records.length; i++) {
                String[] arr = records[i].split(" ");
                if (arr[2].equals("OUT")) {
                    continue;
                }

                boolean out = false;
                for (int j = i + 1; j < records.length; j++) {
                    String[] arr2 = records[j].split(" ");
                    if (arr[1].equals(arr2[1])) {
                        int time1 = Integer.parseInt(arr[0].split(":")[0]) * 60
                                + Integer.parseInt(arr[0].split(":")[1]);

                        int time2 = Integer.parseInt(arr2[0].split(":")[0]) * 60
                                + Integer.parseInt(arr2[0].split(":")[1]);

                        map.put(arr[1], map.getOrDefault(arr[1], 0) + (time2 - time1));
                        out = true;
                        break;
                    }
                }
                // 출차된게 아니라면
                if (!out) {
                    int time1 = Integer.parseInt(arr[0].split(":")[0]) * 60
                            + Integer.parseInt(arr[0].split(":")[1]);

                    map.put(arr[1], map.getOrDefault(arr[1], 0) + (midnight - time1));
                }
            }

            int[] answer = new int[map.size()];
            int index = 0;
            for (String key: map.keySet()) {
                double time = map.get(key);
                if (time > fees[0]) {
                    answer[index] += Math.ceil((time - fees[0]) / fees[2]) * fees[3];
                }
                answer[index] += fees[1];
                index++;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int[] fees = {1, 461, 1, 10};
        String[] records = {"00:00 1234 IN"};
        System.out.println(new Solution().solution(fees, records));
    }
}
