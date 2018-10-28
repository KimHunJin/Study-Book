package Edaily;

import java.util.Scanner;

public class GradeCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalAl = 0;
        int totalDb = 0;
        int totalCs = 0;

        for (int i = 0; i < 3; i++) {
            String[] s = sc.nextLine().split(" ");
            int al = Integer.parseInt(s[0], 10);
            int db = Integer.parseInt(s[1], 10);
            int cs = Integer.parseInt(s[2], 10);
            int sum = al + db + cs;
            totalAl += al;
            totalDb += db;
            totalCs += cs;

            System.out.println(al + " " + db + " " + cs + " " + sum);
        }
        int totalSum = totalAl + totalDb + totalCs;
        System.out.println(totalAl + " " + totalDb + " " + totalCs + " " + totalSum);
    }

}
