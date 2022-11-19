package BackJune.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N16236 {

    static int n;
    static int sharkSize = 2;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, -1};
    static boolean[][] visited;

    static class Position{
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        int sharkX = 0;
        int sharkY = 0;

        StringTokenizer st;
        PriorityQueue<Position> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                // 아기 상어 위치 저장
                if (num == 9) {
                    sharkX = i;
                    sharkY = j;
                }
            }
        }

        // 0: 빈칸
        // 1, 2, 3, 4, 5,6: 칸에 있는 물고기의 크기
        // 9: 아기 상어의 위치
        // 2: 아기 상어 처음 크기
        // 자신의 크기보다 큰 물고기가 있는 칸은 못지나감
        // 자신의 크기보다 작은 상어만 먹을 수 있음
        bfs(sharkX, sharkY);

    }

    private static void bfs(int x, int y) {
        PriorityQueue<Position> queue = new PriorityQueue<>();
        queue.add(new Position(x, y));

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 공간 벗어 나는지 확인
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] < sharkSize && !visited[nx][ny]) {

            }
        }
    }
}
