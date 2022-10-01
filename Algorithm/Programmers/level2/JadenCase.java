package Programmers.level2;

// 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열
public class JadenCase {
    static class Solution {
        public String solution(String s) {
            String answer = "";

            String[] words = s.split(" ");

            for(String word : words) {
                if(word.length() > 0) answer += word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase() + " ";
                else answer += " ";
            }

            if (s.charAt(s.length() - 1) != ' ')
                answer = answer.substring(0, answer.length()-1);

            return answer;
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("3  unFollowed me"));
    }
}
