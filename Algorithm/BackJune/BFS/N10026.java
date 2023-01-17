package BackJune.BFS;

import java.io.*;
import java.util.*;

public class N10026 {
    static int n;
    static String[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new String[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().split("");
        }

        int[] answer = new int[2];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (!visited[x][y]) {
                    answer[0]++;
                    bfs(x, y);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j].equals("G")) arr[i][j] = "R";
            }
        }

        visited = new boolean[n][n];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (!visited[x][y]) {
                    answer[1]++;
                    bfs(x, y);
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] dist = queue.poll();
            int nowX = dist[0];
            int nowY = dist[1];

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (arr[nx][ny].equals(arr[nowX][nowY]) && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
