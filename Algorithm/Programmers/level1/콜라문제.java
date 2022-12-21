package Programmers.level1;

public class 콜라문제 {
    static class Solution {
        public int solution(int a, int b, int n) {
            int answer = 0;

            while (n >= a) {
                int mok = n / a;
                int cola = mok * b;
                answer += cola;
                n = cola + (n - (a * mok));
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(3, 1, 20));
    }
}
