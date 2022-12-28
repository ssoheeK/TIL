package Programmers.level3;

public class 파괴되지않은건물 {
    static class Solution {
        public int solution(int[][] board, int[][] skill) {
            int answer = 0;

            /*for (int i = 0; i < skill.length; i++) {
                for (int j = skill[i][1]; j <= skill[i][3] ; j++) {
                    for (int k = skill[i][2]; k <= skill[i][4]; k++) {
                        if (skill[i][0] == 1) board[j][k] -= skill[i][5];
                        else board[j][k] += skill[i][5];
                    }
                }
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] > 0) answer++;
                }
            }*/

            // 누적합 방식
            // 변화하는 값들을 계속 읽어들인 다음에 한 번에 누적합으로 그 변화값의 결과를 낼 수 있다.
            // skill원소 하나당 O(N)의 시간 복잡도가 아닌 O(1)의 시간복잡도로 처리가 가능하다.
            int[][] sum = new int[board.length + 1][board[0].length + 1];
            for (int i = 0; i < skill.length; i++) {
                int bit = -1;
                if (skill[i][0] == 2) bit = 1;
                sum[skill[i][1]][skill[i][2]] += skill[i][5] * bit;
                sum[skill[i][3] + 1][skill[i][4] + 1] += skill[i][5] * bit;
                sum[skill[i][1]][skill[i][4] + 1] += -skill[i][5] * bit;
                sum[skill[i][3] + 1][skill[i][2]] += -skill[i][5] * bit;
            }

            // 행 누적합(위->아래)
            for (int i = 1; i < sum.length; i++) {
                for (int j = 0; j < sum[i].length; j++) {
                    sum[i][j] += sum[i - 1][j];
                }
            }

            // 열 누적합(왼쪽->오른쪽)
            for (int i = 0; i < sum.length; i++) {
                for (int j = 1; j < sum[i].length; j++) {
                    sum[i][j] += sum[i][j - 1];
                }
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] + sum[i][j] > 0) answer++;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        System.out.println(new Solution().solution(board, skill));
    }
}
