package baekjoon;

import java.util.Scanner;

public class BJ_2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int result = a * b * c;
        int[] v = new int[10];

        String s = "" + result;

        for (int i = 0; i < s.length(); i++) {
            char k = s.charAt(i);
            v[k-'0']++;
        }

        for(int n : v) {
            System.out.println(n);
        }
    }
}
