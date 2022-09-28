package BackJune.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 프린터 큐 문제
public class N1966 {

    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());   // 문서의 개수
            m = Integer.parseInt(st.nextToken());   // 문서가 현재 queue에서 몇번째 놓여 있는지

            st = new StringTokenizer(br.readLine(), " ");

            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> indexQueue = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                queue.offer(Integer.parseInt(st.nextToken()));
                indexQueue.offer(j);
            }

            simulation(queue, indexQueue);
        }
        System.out.println(sb);
    }

    private static void simulation(Queue<Integer> queue, Queue<Integer> indexQueue) {
        int count = 1;
        while (!queue.isEmpty()) {
            int max = Collections.max(queue);
            int cur = queue.poll();
            int curIndex = indexQueue.poll();

            // 인쇄가 가능할때
            if (cur == max) {
                // 찾아야할 문서를 인쇄 했다면 count출력
                if (curIndex == m) {
                    sb.append(count).append("\n");
                    break;
                }
                count++;
            } else {
                queue.offer(cur);
                indexQueue.offer(curIndex);
            }
        }
    }
}
