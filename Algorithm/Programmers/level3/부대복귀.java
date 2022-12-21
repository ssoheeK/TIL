package Programmers.level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 부대복귀 {
    static class Solution {
        public int[] solution(int n, int[][] roads, int[] sources, int destination) {
            int[] answer = new int[sources.length];

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] road : roads) {
                int a = road[0];
                int b = road[1];

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            int[] shortest = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                shortest[i] = Integer.MAX_VALUE;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(destination);
            shortest[destination] = 0;

            while (!queue.isEmpty()) {
                int v = queue.poll();

                for (int i = 0; i < graph.get(v).size(); i++) {
                    int to = graph.get(v).get(i);
                    if (shortest[to] > shortest[v] + 1) {
                        shortest[to] = shortest[v] + 1;
                        queue.add(to);
                    }
                }
            }

            for (int i = 0; i < sources.length; i++) {
                answer[i] = shortest[sources[i]] != Integer.MAX_VALUE ? shortest[sources[i]] : -1;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int[][] roads = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
        int[] sources = {1, 3, 5};
        System.out.println(new Solution().solution(5, roads, sources, 5));
    }
}
