package BackJune.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N5369 {
    static Node head;
    static class Node {
        int key;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.key = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n;
        while (true) {
            n = br.readLine();
            if (n == null || n.equals("")) {
                break;
            }
            addNode(Integer.parseInt(n));
        }

        postOrder(head);
    }

    private static void postOrder(Node cur) {
        if (cur == null) {
            return;
        }

        postOrder(cur.left);
        postOrder(cur.right);
        System.out.println(cur.key);
    }

    private static void addNode(int key) {
        head = addNode(head, key);
    }

    private static Node addNode(Node node, int key) {
        if (node == null) {
            return new Node(key, null, null);
        }

        if (key < node.key) {
            node.left = addNode(node.left, key);
        } else {
            node.right = addNode(node.right, key);
        }

        return node;
    }
}
