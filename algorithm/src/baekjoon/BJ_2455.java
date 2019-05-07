package baekjoon;

import java.util.Scanner;

public class BJ_2455 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int max = 0;
        for (int i = 0; i < 4; i++) {
            String s[] = sc.nextLine().split(" ");
            int out = Integer.parseInt(s[0]);
            int in = Integer.parseInt(s[1]);

            sum = sum + in - out;
            if(sum > max ) {
                max = sum;
            }
        }
        System.out.println(max);
    }
}
