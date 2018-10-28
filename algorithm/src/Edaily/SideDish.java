package Edaily;

import java.util.Scanner;

public class SideDish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0;i<Math.pow(2,n);i++) {
            String result = Integer.toBinaryString(i);
            while (result.length() < n) {
                result = "0" + result;
            }
            System.out.println(result);
        }
    }
}
