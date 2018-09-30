package line.Intern;

import java.util.Scanner;
import java.util.StringTokenizer;

public class A {
    public static void main(String... args) {
        String input = new Scanner(System.in).nextLine().trim();
        final StringTokenizer tokenizer = new StringTokenizer(input);

        int currentMoney = 20000;
        while (tokenizer.hasMoreTokens()) {
            int distance = Integer.parseInt(tokenizer.nextToken());
            // @todo Write your code here.
            if (distance > 178 || distance < 4) {
                break;
            }
            if (distance <= 40) {
                if (currentMoney >= 720) {
                    currentMoney -= 720;
                } else {
                    break;
                }
            } else {
                int addCharge = distance - 41; // 8키로로 나누어 떨어질 때 요금 추가를 위해
                addCharge = (addCharge / 8) + 1;
                int total = 720 + (80 * addCharge);
                if (currentMoney >= total) {
                    currentMoney -=total;
                } else {
                    break;
                }
            }
        }
        System.out.println(currentMoney);
        // @todo Write your code here.
    }
}