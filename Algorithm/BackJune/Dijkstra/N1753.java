package BackJune.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1753 {

    static List<Node>[] list;

    static int[] dist;
    static int v, e;
    static int INF = 100_000_000;

    static class Node implements Comparable<Node> {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken()); // 정점
        e = Integer.parseInt(st.nextToken()); // 간선
        int start = Integer.parseInt(br.readLine());
        dist = new int[v + 1];
        list = new ArrayList[v + 1];
        Arrays.fill(dist, INF);

        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken()); //가중치

            list[a].add(new Node(b, w));
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        // 출력
        for (int i = 1; i <= v; i++) {
            if (dist[i] == INF) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[v + 1];
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.to;

            // 방문을 한 노드라면 패스
            if (check[cur]) continue;
            check[cur] = true; //방문 체크

            for (Node node: list[cur]) {
                // 최소값으로 갱신
                if (dist[node.to] > dist[cur] + node.weight) {
                    dist[node.to] = dist[cur] + node.weight;
                    queue.add(new Node(node.to, dist[node.to]));
                }
            }
        }
    }
}