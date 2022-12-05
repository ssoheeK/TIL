package BackJune.Tree;

import java.io.*;
import java.util.*;

public class N1068 {
    static int root, removeNode, count = 0;
    static Node[] nodes;

    static class Node {
        int data;
        ArrayList<Node> child = new ArrayList<>();

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int parentNode = Integer.parseInt(st.nextToken());

            // root인 경우
            if (parentNode == -1) {
                root = i;
                continue;
            }

            nodes[parentNode].child.add(nodes[i]);
        }

        removeNode = Integer.parseInt(br.readLine());
        if (removeNode != root) {
            remove(root);
            bfs(root);
        }
        System.out.println(count);
    }

    private static void bfs(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int v = queue.poll();

            if (nodes[v].child.size() == 0) {
                count++;
            } else {
                for (Node node : nodes[v].child) {
                    queue.add(node.data);
                }
            }
        }
    }

    private static void dfs(int index) {
        if (nodes[index].child.size() == 0) {
            count++;
            return;
        }

        for (Node node: nodes[index].child) {
            dfs(node.data);
        }
    }

    private static void remove(int index) {
        for (Node node: nodes[index].child) {
            if (node.data == removeNode) {
                nodes[index].child.remove(node);
                return;
            }
            remove(node.data);
        }
    }
}
