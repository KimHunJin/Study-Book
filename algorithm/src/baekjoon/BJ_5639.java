package baekjoon;

import jdk.nashorn.api.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BJ_5639 {

    public static void main(String[] args) {
        new BJ_5639().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s;
            Tree tree = new Tree();
            while ((s = br.readLine()) != null) {
                int number = Integer.parseInt(s, 10);
                makeTree(tree, number);
                printTree(tree);
            }

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private void printTree(Tree tree) {
        while (tree.root == null) {

        }
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
    }
}
