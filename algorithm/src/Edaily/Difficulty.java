package Edaily;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Difficulty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        Arrays.sort(num);

        List<Integer> m = new ArrayList<>();
        m.add(num[0]);
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                m.add(0, num[i]);
            } else {
                m.add(num[i]);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int value;
            if (i + 1 < n) {
                value = Math.abs(m.get(i) - m.get(i + 1));
            } else {
                value = Math.abs(m.get(i) - m.get(0));
            }
            max = max > value ? max : value;
        }

        System.out.println(max);
    }
}
