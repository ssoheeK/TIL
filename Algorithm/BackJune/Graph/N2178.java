package BackJune.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2178 {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            int[] in = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            arr[i] = in;
        }

        bfs(0, 0);
        System.out.println(arr[n - 1][m - 1]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                    if (!visited[nextX][nextY] && arr[nextX][nextY] == 1) {
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        arr[nextX][nextY] = arr[nowX][nowY] + 1;
                    }
                }
            }
        }
    }
}
