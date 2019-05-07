package baekjoon;

import java.util.Scanner;

public class BJ_2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum = i;
            int k = i;
            do {
                k += (sum % 10);
                sum = sum / 10;
            }while (sum > 0);
            if(k==n) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);

    }
}

