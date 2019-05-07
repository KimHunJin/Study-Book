package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BJ_5639_copy {

    public static void main(String[] args) {
        new BJ_5639_copy().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Scanner sc = new Scanner(System.in);
//            String s = br.readLine();
            Tree tree = new Tree();
            while (sc.hasNextLine()) {
                int n = Integer.parseInt(sc.nextLine(), 10);
                makeTree(tree, n);
//                s = br.readLine();
//                br.readLine();
            }
            printTree(tree);

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private void printTree(Tree tree) {
        tree.post(tree.root);
    }

    private void makeTree(Tree tree, int n) {
        tree.add(n);
    }

    class Node {
        int value;
        Node leftNode;
        Node rightNode;

        Node(int value) {
            this.value = value;
            leftNode = null;
            rightNode = null;
        }
    }

    class Tree {
        Node root;

        Node addRecursive(Node current, int value) {
            if (current == null) {
                return new Node(value);
            }

            if (value < current.value) {
                current.leftNode = addRecursive(current.leftNode, value);
            } else if (value > current.value) {
                current.rightNode = addRecursive(current.rightNode, value);
            } else {
                return current;
            }
            return current;
        }

        void add(int value) {
            root = addRecursive(root, value);
        }

        void post(Node node) {
            if (node != null) {
                post(node.leftNode);
                post(node.rightNode);
                System.out.println(node.value);
            }
        }
    }
}
