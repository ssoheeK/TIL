package Programmers.level2;

public class 피로도 {
    static class Solution {
        int answer = 0;

        public int solution(int k, int[][] dungeons) {
            int count = 0;

            // DFS
            boolean[] visited = new boolean[dungeons.length];
            dfs(k, dungeons, visited, count);

            return answer;
        }

        private void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
            for (int i = 0; i < dungeons.length; i++) {
                if (!visited[i] && k >= dungeons[i][0]) {
                    visited[i] = true;
                    dfs(k - dungeons[i][1], dungeons, visited, count + 1);
                    visited[i] = false;
                }
            }
            answer = Math.max(answer, count);
        }
    }

    public static void main(String[] args) {
        int[][] dungeons = {{80, 20},
                {50, 40},
                {30, 10}};
        System.out.println(new Solution().solution(80, dungeons));
    }
}
