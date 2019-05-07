package baekjoon;

import java.util.Scanner;

public class BJ_9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] array = new long[101];
        array[0] = 1;
        array[1] = 1;
        array[2] = 1;

        for (int i = 3; i < 101; i++) {
            array[i] = array[i - 3] + array[i - 2];
        }

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            System.out.println(array[k-1]);
        }
    }
}
