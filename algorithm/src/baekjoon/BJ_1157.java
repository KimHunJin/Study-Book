package baekjoon;

import java.util.Scanner;

public class BJ_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] arr = new int[26];


        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c - 'a' >= 0) {
                arr[c-'a'] ++;
            } else {
                arr[c-'A'] ++;
            }
        }

        int max = 0;

        String result = "";

        for(int i=0;i<arr.length;i++) {
            if(max == arr[i]) {
                result = "?";
            }
            if(arr[i] > max) {
                max = arr[i];
                result = String.valueOf((char)(i + 'A'));
            }
        }

        System.out.println(result);
    }
}
