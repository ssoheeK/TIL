package BackJune.BFS;

import java.io.*;
import java.util.*;

public class N14502 {
    static int n, m, answer = 0;
    static int[][] laboratory;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        laboratory = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                laboratory[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int wallCount) {
        if (wallCount == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (laboratory[i][j] == 0) {
                    laboratory[i][j] = 1;
                    dfs(wallCount + 1);
                    laboratory[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        // 바이러스 위치를 Queue에 넣어준다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (laboratory[i][j] == 2) queue.add(new int[]{i, j});
            }
        }

        int[][] copyLaboratory = new int[n][m];
        for (int i = 0; i < n; i++) {
            copyLaboratory[i] = laboratory[i].clone();
        }

        // 바이러스를 퍼뜨리기 위한 bfs 탐색
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            int x = coordinate[0];
            int y = coordinate[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < n && ny < m && nx >= 0 && ny >= 0) {
                    if (copyLaboratory[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny});
                        copyLaboratory[nx][ny] = 2;
                    }
                }
            }
        }

        // safezone 확인
        checkSafeZoneTotal(copyLaboratory);
    }

    private static void checkSafeZoneTotal(int[][] copyLaboratory) {
        int safeZone = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyLaboratory[i][j] == 0) {
                    safeZone++;
                }
            }
        }

        answer = Math.max(answer, safeZone);
    }
}
