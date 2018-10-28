package Edaily;

import java.util.Scanner;

public class PrintStudentInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++) {
            String[] tmp = sc.nextLine().split(" ");
            System.out.println(tmp[0]+ " : " + tmp[1] + "점");
        }
    }
}
