package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_9521 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tmp = sc.nextLine().split(" ");

        int n = Integer.parseInt(tmp[0], 10);
        int k = Integer.parseInt(tmp[1], 10);

        int[] m = new int[n + 1];
        Arrays.fill(m, k);

        tmp = sc.nextLine().split(" ");

        for (int i = 0; i < tmp.length; i++) {

        }
    }
}
