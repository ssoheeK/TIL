package BackJune.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1991 {
    static class Node{
        char data;
        Node left;
        Node right;

        public Node(char data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node((char)('A' + i), null, null);
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int data = st.nextToken().charAt(0) - 'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (left != '.') {
                nodes[data].left = nodes[left - 'A'];
            }
            if (right != '.') {
                nodes[data].right = nodes[right - 'A'];
            }
        }

        // 전위 순회
        preOrder(nodes[0]);
        System.out.println();

        // 중위 순회
        inOrder(nodes[0]);
        System.out.println();

        // 후위 순회
        postOrder(nodes[0]);
        System.out.println();
    }

    private static void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    private static void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
    }

    private static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }
}
