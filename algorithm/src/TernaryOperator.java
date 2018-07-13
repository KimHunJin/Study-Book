import java.util.Scanner;

/**
 * 삼항 연산자
 *
 * C++, Java 등의 프로그래밍 언어에서는 '?', ':' 키워드를 사용하여
 * 아래와 같은 형식의 삼항 연산자(조건 연산자)를 제공합니다.
 * condition이 true이면 연산자는 expr1의 값을 반환하며, false 이면
 * expr2를 반환합니다.
 *
 * condition ? expr1 : expr2
 *
 * 삼항 연산자 표현식을 수행했을 때 반환되는 결과값을 출력하는 프로그램을 작성해 주시기 바랍니다.
 *
 * 이번 문제에서 condition은 두 개의 자연수와 하나의 비교연산자로만 이루어져 있으며,
 * expr1과 expr2는 자연수 이거나 또 다른 삼항 연산자 표현식입니다.
 * (중첩 삼항 연산자) 연산자를 표현할 때 괄호 '(', ')'는 사용하지 않습니다.
 * 자연수의 범위는 1<=N<=999 이며, 사용되는 비교연산자 종류는
 * ==, !=, >, <, >=, <= 입니다. 입력된 표현식은 오류가 아닌 경우 자연수를 반환합니다.
 *
 * 예를 들어 1 != 2 ? 3 > 4 ? 5 >= 6 ? 7 : 8 == 9 ? 10 : 11 : 12 : 13
 * 의 반환 값은 12입니다.
 * 풀이 과정은 아래와 같습니다.
 *
 * 1 != 2 ? 3 > 4 ? 5 >= 6 ? 7 : 8 == 9 ? 10 : 11 : 12 : 13
 * --> 1 != 2 ? 3 > 4 ? 5 >= 6 ? 7 : (8 == 9 ? 10 : 11) : 12 : 13
 * --> 1 != 2 ? 3 > 4 ? (5 >= 6 ? 7 : 11) : 12 : 13
 * --> 1 != 2 ? (3 > 4 ? 11 : 12) : 13
 * --> 1 != 2 ? 12 : 13
 * --> 12
 *
 * input
 * 1 > 2 ? 3 : 4 > 5 ? 6 : 7
 * 33 != 1 ? 13 > 35 ? 4 >= 5 ? 0 : 4 == 2 ? 13 : 4 : 23 : 2
 *
 * output
 * 7
 * 23
 *
 * solution
 * tree
 *
 * but..
 * has exception
 */
public class TernaryOperator {
    private static final String BIG = ">";
    private static final String SMALL = "<";
    private static final String BIG_SAME = ">=";
    private static final String SMALL_SAME = "<=";
    private static final String NOT_SAME = "!=";
    private static final String SAME = "==";

    private static final String QUESTION = "\\?";
    private static final String COLON = ":";

    public static void main(String[] args) {
        new TernaryOperator().solve();
    }

    class Tree {
        String value;
        Tree left;
        Tree right;

        Tree() {

        }

        Tree(String value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        String words = sc.nextLine();

        String[] nodes = words.split("\\? | : ");
        Tree tree = new Tree(nodes[0], null, null);
        makeTree(tree, nodes);

        oper(tree);
    }

    private void makeTree(Tree tree, String[] words) {
        makeTree(tree, words, 1, words.length-1);
    }

    private void makeTree(Tree tree, String[] words, int start, int last) {
        if(start >= last) {
            return;
        }

        if (words[start].split(" ").length > 1) {
            tree.left = new Tree(words[start], null, null);
            tree.right = new Tree(words[last], null, null);
            makeTree(tree.left, words, start + 1, last - 1);
        } else {
            tree.left = new Tree(words[start], null, null);
            tree.right = new Tree(words[start + 1], null, null);
            makeTree(tree.right, words, start + 2, last);
        }
    }

    private void oper(Tree tree) {
        if (tree.value.split(" ").length > 1) {
            if (oper(tree.value)) {
                oper(tree.left);
            } else {
                oper(tree.right);
            }
        } else {
            System.out.println(tree.value);
        }
    }

    private boolean oper(String word) {
        String[] words = word.split(" ");
        boolean result = false;
        int a = Integer.parseInt(words[0]);
        int b = Integer.parseInt(words[2]);
        switch (words[1]) {
            case BIG: {
                result = a > b;
                break;
            }
            case SMALL: {
                result = a < b;
                break;
            }
            case BIG_SAME: {
                result = a >= b;
                break;
            }
            case SMALL_SAME: {
                result = a <= b;
                break;
            }
            case SAME: {
                result = a == b;
                break;
            }
            case NOT_SAME: {
                result = a != b;
                break;
            }
        }
        return result;
    }
}
