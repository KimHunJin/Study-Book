package Edaily;

import java.util.Scanner;

public class NumberChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(2 + " " + Integer.toBinaryString(n));
        System.out.println(8 + " " + Integer.toOctalString(n));
        System.out.println(16 + " " + Integer.toHexString(n).toUpperCase());
    }
}
