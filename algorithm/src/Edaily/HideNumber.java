package Edaily;

import java.util.Scanner;

public class HideNumber {
    public static void main(String[] args) {
        int[] m = new int[10];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++) {
            int k = sc.nextInt();
            m[k]++;
        }
        for(int i=0;i<10;i++) {
            if(m[i] == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
