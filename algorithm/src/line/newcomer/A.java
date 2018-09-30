package line.newcomer;

import java.util.Scanner;
import java.util.StringTokenizer;

public class A {
    public static void main(String... args) {
        String input = new Scanner(System.in).nextLine().trim();
        final StringTokenizer tokenizer = new StringTokenizer(input);

        int value = 20000;
        while (tokenizer.hasMoreTokens()) {
            int distance = Integer.parseInt(tokenizer.nextToken());
            // @todo Write your code here.
            if(distance <= 40) {
                if(value >= 720) {
                    value -= 720;
                } else {
                    break;
                }
            } else if(distance <= 178){
                distance = distance - 41;
                distance = (distance / 8) + 1;
                int total = 720 + (80 * distance);
                if(value >= total) {
                    value -= 720 + (80 * distance);
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        System.out.println(value);
        // @todo Write your code here.
    }
}