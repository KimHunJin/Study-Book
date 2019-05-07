package baekjoon;

import java.util.Scanner;

public class BJ_10809 {
    public static void main(String[] args) {
        int[] alphabet = new int[26];

        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = -1;
        }

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(alphabet[c-'a'] == -1) {
                alphabet[c - 'a'] = i;
            }
        }

        for(int n : alphabet) {
            System.out.print(n + " ");
        }
    }
}
