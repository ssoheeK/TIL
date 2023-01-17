package Programmers.level3;

import java.util.*;

public class 등산코스정하기 {
    static ArrayList<ArrayList<Node>> list;
    static boolean[] visited;
    static HashMap<Integer, String> map = new HashMap<>();
    static int[] answer;
    static class Node implements Comparable<Node>{
        int to;
        int distance;

        public Node(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if (distance == o.distance) return to - o.to;
            return distance - o.distance;
        }
    }

    static public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        answer = new int[2];
        for (int i = 0; i < 2; i++) {
            answer[i] = Integer.MAX_VALUE;
        }

        list = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < paths.length; i++) {
            list.get(paths[i][0]).add(new Node(paths[i][1], paths[i][2]));
            list.get(paths[i][1]).add(new Node(paths[i][0], paths[i][2]));
        }

        // 최단거리 방문을 위해 오름차순 정렬
        for (int i = 0; i < list.size(); i++) {
            Collections.sort(list.get(i));
        }



        return answer;
    }

    private static void bfs(int gate, int summit) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(gate);
        visited[gate] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (int i = 0; i < list.get(v).size(); i++) {
                if (!visited[list.get(v).get(i).to]) {
                    visited[list.get(v).get(i).to] = true;
                    answer[1] = Math.min(answer[1], list.get(v).get(i).distance);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] path = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
        int[] gates = {1, 3};
        int[] summits = {5};
        System.out.println(solution(6 ,path, gates, summits));
    }
}
