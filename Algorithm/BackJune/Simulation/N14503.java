package BackJune.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14503 {

    static int x, y;
    static int count = 1; // 로봇 청소기가 청소하는 칸의 개수
    static int[][] arr;
    // 북동남서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        arr = new int[x][y];

        st = new StringTokenizer(br.readLine(), " ");
        // 로봇 청소기가 있는 칸의 좌표 (r,c)
        // d가 0: 북쪽, d가 1: 동쪽, d가 2: 남쪽, d가 3: 서쪽
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < y; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);
        System.out.println(count);
    }

    private static void dfs(int r, int c, int direction) {
        arr[r][c] = -1; // 현재 위치 청소

        for (int i = 0; i < 4; i++) {
            // 왼쪽 방향으로 변환(북 -> 서 -> 남 -> 동)
            direction = (direction + 3) % 4;
            int nx = r + dx[direction];
            int ny = c + dy[direction];

            // 청소가 안된 곳
            if (ny >= 0 && ny < y && nx >= 0 && nx < x && arr[nx][ny] == 0) {
                count++;
                dfs(nx, ny, direction);
                return;
            }
        }

        // 더이상 청소를 할 공간이 없는 경우
        // 네 방향 모두 청소가 되어 있거나 벽인 경우
        int back = (direction + 2) % 4;
        int bx = r + dx[back];
        int by = c + dy[back];

        // 후진하는 칸이 벽이면 안됨
        if (by >= 0 && by < y && bx >= 0 && bx < x && arr[bx][by] != 1) {
            // 후진할때 방향 유지
            dfs(bx, by, direction);
        }
    }
}