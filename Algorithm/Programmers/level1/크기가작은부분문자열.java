package Programmers.level1;

public class 크기가작은부분문자열 {
    static class Solution {
        public int solution(String t, String p) {
            int answer = 0;

            // p의 범위가 18이하 이므로 Long 타입 사용
            for (int i = 0; i < t.length() - p.length() + 1; i++) {
                if (Long.parseLong(t.substring(i, i + p.length())) <= Long.parseLong(p)) {
                    answer++;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("500220839878", "7"));
    }
}
