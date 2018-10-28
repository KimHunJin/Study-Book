package Edaily;

import java.util.Scanner;

public class Gaus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print("{");
        for(int i=n;i<n*2-1;i++) {
            System.out.print(i+", ");
        }
        System.out.print(n*2-1+"}");
    }
}
