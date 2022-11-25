package Programmers.level2;

public class 두개이하로다른비트 {
    static class Solution {
        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                // 짝수인경우 맨뒤의 1만 바꾸어 주면 되므로 number + 1이 답이된다.
                if (numbers[i] % 2 == 0) {
                    answer[i] = numbers[i] + 1;
                    continue;
                }

                StringBuilder sb = new StringBuilder();
                String bit = Long.toBinaryString(numbers[i]);
                if (!bit.contains("0")) {
                    sb.append("10");
                    sb.append(bit.substring(1));
                } else {
                    int lastIndex = bit.lastIndexOf("0");
                    int changeIndex = bit.indexOf("1", lastIndex);

                    sb.append(bit, 0, lastIndex).append("1");
                    sb.append("0");
                    sb.append(bit.substring(changeIndex + 1));
                }

                answer[i] = Long.parseLong(sb.toString(), 2);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new long[]{2, 19}));
    }
}
