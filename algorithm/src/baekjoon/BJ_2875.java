package baekjoon;

import java.util.Scanner;

public class BJ_2875 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int sum = n + m;
        sum = sum - k;
        if (sum < 3) {
            System.out.println(0);
        } else {
            int num = sum / 3;
            while (true) {
                if (n >= num * 2 && m >= num) {
                    System.out.println(num);
                    break;
                }
                num--;
            }
        }
    }
}
