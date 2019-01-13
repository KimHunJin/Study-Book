package baekjoon;

import java.util.Scanner;

public class BJ_2725 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] result = new int[1001];
        int[] v = new int[1001];

        result[0] = 0;
        result[1] = 3;
        v[0] = 0;
        v[1] = 2;
        v[2] = 2;

        for (int i = 3; i < 1000; i+=2) {
            v[i] = v[i-1] * 2;
            v[i+1] = v[i-1] * 2;
        }

        for (int i = 2; i < 1000; i++) {
            result[i] = result[i-1] + v[i];
        }

        System.out.println(result[231]);
    }
}
