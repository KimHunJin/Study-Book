package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BJ_1352 {
    public static void main(String[] args) {
        new BJ_1352().solve();
    }

    private List<String> list = new ArrayList<>();

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int findSum = sc.nextInt();
        find(findSum);
    }

    private void find(int number) {
        int n = 1;
        int count = 0;
        while (true) {
            if (number <= n) {
                break;
            }
            n *= 2;
            count++;
        }

        int[][] scope = {
                {0, 0},
                {1, 1},
                {3, 3},
                {6, 7},
                {10, 15},
                {16, 31},
                {32, 63},
                {64, 100}
        };
        int[] start = {
                0,
                1,
                2,
                3,
                4,
                6,
                17,
                43
        };

        String[] word = {"A", "B", "C", "D", "E", "F", "G" ,"H", "I", "J", "K", "L", "M"};
        int[] wordCount = new int[count];

        String[] s = new String[number+1];
        for (int i = 0; i < scope.length; i++) {
            if(number >= scope[i][0] && number <= scope[i][1]) {
                int p = number - scope[i][0];
                p = start[i] + p;
                s[p] = word[i];
                for(int j=1;j<count;j++) {
                    s[j] = word[j];
                }
            }
        }
    }
}
