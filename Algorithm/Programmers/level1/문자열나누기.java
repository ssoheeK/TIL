package Programmers.level1;

public class 문자열나누기 {
    static class Solution {
        public int solution(String s) {
            int answer = 0;

            while (s.length() > 0) {
                answer++;

                char x = s.charAt(0);
                int xCount = 1, otherCount = 0;

                for (int i = 1; i < s.length(); i++) {
                    if (x == s.charAt(i)) xCount++;
                    else otherCount++;

                    if (xCount == otherCount) {
                        break;
                    }
                }
                s = s.substring(xCount + otherCount);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("abracadabra"));
    }
}
