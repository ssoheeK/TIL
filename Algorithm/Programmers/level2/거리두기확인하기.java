package Programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 거리두기확인하기 {
    static class Solution {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        public int[] solution(String[][] places) {
            int[] answer = new int[places.length];

            for (int i = 0; i < places.length; i++) {
                String[] place = places[i];
                boolean check = true;
                for (int j = 0; j < 5 && check; j++) {
                    for (int k = 0; k < 5 && check; k++) {
                        if (place[j].charAt(k) == 'P') {
                            if (!bfs(j, k, place)) {
                                check = false;
                            }
                        }
                    }
                }
                answer[i] = check ? 1 : 0;
            }

            return answer;
        }

        private boolean bfs(int x, int y, String[] place) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{x, y});

            while (!queue.isEmpty()) {
                int[] position = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = position[0] + dx[i];
                    int ny = position[1] + dy[i];

                    if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || (nx == x && ny == y)) continue;

                    int d = Math.abs(nx - x) + Math.abs(ny - y);

                    if (place[nx].charAt(ny) == 'P' && d <= 2) return false;
                    else if (place[nx].charAt(ny) == 'O' && d < 2) queue.offer(new int[] {nx, ny});
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(new Solution().solution(places));
    }
}
