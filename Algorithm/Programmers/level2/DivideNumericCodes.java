package Programmers.level2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        List<Integer> divisorA = this.getDivisor(arrayA);
        List<Integer> divisorB = this.getDivisor(arrayB);

        int targetA = this.getMaxNonDivisor(arrayB, divisorA);
        int targetB = this.getMaxNonDivisor(arrayA, divisorB);

        return Math.max(targetA, targetB);
    }

    private int getMaxNonDivisor(int[] arrays, List<Integer> divisors) {
        int target = 0;
        for (int divisor : divisors) {
            boolean isNoDivide = true;
            for (int num : arrays) {
                if (num % divisor == 0) {
                    isNoDivide = false;
                    break;
                }
            }
            if (isNoDivide) {
                target = Math.max(target, divisor);
            }
        }
        return target;
    }

    public List<Integer> getDivisor(int[] arrays) {
        List<Integer> list = new ArrayList<>();
        int len = arrays.length;
        int min = arrays[0];

        for (int i = 2; i <= min; i++) {
            boolean isDivide = true;
            for (int j = 0; j < len; j++) {
                if (arrays[j] % i != 0) {
                    isDivide = false;
                    break;
                }
            }
            if (isDivide) {
                list.add(i);
            }
        }
        return list;
    }
}

public class DivideNumericCodes {
    public static void main(String[] args) {
        int[] arrayA = {14, 35, 119};
        int[] arrayB = {18, 30, 102};
        System.out.println(new Solution().solution(arrayA, arrayB));
    }
}
