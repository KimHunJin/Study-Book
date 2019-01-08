package baekjoon;

import java.util.Scanner;

public class BJ_1806 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int solution = sc.nextInt();

        int start = 0;
        int last = 0;

        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        int sum = 0;
        int size = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += values[i];

            while (sum >= solution) {
                int length = last - start + 1;
                size = size > length ? length : size;
                sum -= values[start];
                start++;
            }
            last++;
        }

        if(size == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(size);
        }
    }
}
