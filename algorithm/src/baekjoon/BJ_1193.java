package baekjoon;

import java.util.Scanner;

public class BJ_1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum = 0;
        int i;
        for (i = 1; sum < n; i++) {
            sum += i;
        }

        i = i - 1;

        int first;
        int second;

        if(i%2==0) {
            first = i;
            second = 1;
            while (sum != n) {
                sum--;
                first--;
                second++;
            }
            System.out.println(first+"/"+second);
        } else {
            first = 1;
            second = i;
            while (sum != n) {
                sum--;
                first++;
                second--;
            }
            System.out.println(first+"/"+second);
        }

    }
}
