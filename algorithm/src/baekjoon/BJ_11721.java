package baekjoon;

import java.util.Scanner;

public class BJ_11721 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int size = s.length();
        int count = size / 10;
        int current = 0;
        for (int i = 0; i < count; i++) {
            System.out.println(s.substring(current, current+10));
            current += 10;
        }
        System.out.println(s.substring(current, s.length()));
    }
}
