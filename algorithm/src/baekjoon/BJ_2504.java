package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class BJ_2504 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        Stack<Character> bracketStack = new Stack<Character>();

        Stack<Integer> numberStack = new Stack<>();

        char open[] = {'(', '['};
        char close[] = {')', ']'};
        int value[] = {2, 3};

        int sum = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < open.length; j++) {
                if (c == open[j]) {
                    bracketStack.push(c);
                    break;
                }
                if (c == close[j]) {
                    char openCharacter = bracketStack.pop();
//                    if (openCharacter ==)
                    sum *= value[j];
                    if (bracketStack.isEmpty()) {
                        numberStack.push(sum);
                    }
                }
            }
        }

        int result = 0;
        while (!numberStack.isEmpty()) {
            result += numberStack.pop();
        }
        System.out.println(result);
    }
}
