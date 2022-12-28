package Programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class 테이블해시함수 {
    static class Solution {
        public int solution(int[][] data, int col, int row_begin, int row_end) {
            int answer = 0;

            // data 정렬
            Arrays.sort(data, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[col - 1] == o2[col - 1]) return o2[0] - o1[0];
                    return o1[col - 1] - o2[col - 1];
                }
            });

            for (int i = row_begin - 1; i < row_end; i++) {
                int sum = 0;
                for (int j = 0; j < data[i].length; j++) {
                    sum += data[i][j] % (i + 1);
                }
                answer = answer ^ sum;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int[][] data = {{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}};
        System.out.println(new Solution().solution(data, 2, 2, 3));
    }
}
