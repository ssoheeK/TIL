package BackJune.Graph;

import java.io.*;
import java.util.*;

public class N1260 {

    static int n, m, v;
    static int[][] nodes;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 노드의 수
        m = Integer.parseInt(st.nextToken()); // 간선의 수
        v = Integer.parseInt(st.nextToken()); // 시작 노드

        nodes = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[a][b] = nodes[b][a] = 1;
        }

        dfs2(v);
        visited = new boolean[n + 1];
        bsf(v);

        System.out.println(sb);
    }

    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(" ");

        for (int i = 1; i <= n; i++) {
            if (nodes[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    private static void dfs2(int v) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;

        while (!stack.isEmpty()) {
            int id = stack.pop();
            sb.append(id).append(" ");

            for (int i = 1; i <= n; i++) {
                if (nodes[id][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                    break;
                }
            }
        }
        sb.append("\n");
    }

    private static void bsf(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int id = queue.poll();
            sb.append(id).append(" ");

            for (int i = 1; i <= n; i++) {
                if (nodes[id][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
