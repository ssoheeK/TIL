package Programmers.level1;

public class 옹알이 {
    static class Solution {
        public int solution(String[] babbling) {
            int answer = 0;
            String[] keyword = {"aya", "ye", "woo", "ma"};

            for (String babble: babbling) {
                babble = replaceKeyword(keyword, babble);

                if (babble.matches("^[0-9]*$") && isContinuity(babble)) {
                    answer++;
                }
            }

            return answer;
        }

        private boolean isContinuity(String babble) {
            for (int i = 0; i < babble.length() - 1; i++) {
                if (babble.charAt(i) == babble.charAt(i + 1)) {
                    return false;
                }
            }
            return true;
        }

        private String replaceKeyword(String[] keyword, String babble) {
            for (int i = 0; i < keyword.length; i++) {
                babble = babble.replaceAll(keyword[i], String.valueOf(i));
            }
            return babble;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));

    }
}
