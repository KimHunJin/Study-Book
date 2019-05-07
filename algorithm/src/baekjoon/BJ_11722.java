package baekjoon;

import java.util.Scanner;

public class BJ_11722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine(), 10);
        int[] numbers = new int[n + 1];
        String[] tmp = sc.nextLine().split(" ");
        for (int i = 1; i < n+1; i++) {
            numbers[i] = Integer.parseInt(tmp[i - 1], 10);
        }

        int[][] map = new int[n + 1][n + 1];

        int max = 0;

        for (int i = 1; i < map.length; i++) {
            int current = numbers[i];
            int value = map[i - 1][i];
            map[i][i] = value + 1;
            max = Math.max(max, map[i][i]);
            for (int j = i+1; j < map[i].length; j++) {
                int diff = numbers[j];
                if (current > diff) {
                    map[i][j] = Math.max(value + 1, map[i-1][j]);
                } else {
                    map[i][j] = map[i-1][j];
                }
//                System.out.println("max : " + max + " map : " + map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

//        for(int k: numbers) {
//            System.out.print(k+ "\t");
//        }
//        System.out.println();
//        for(int[] k: map) {
//            for(int kk: k) {
//                System.out.print(kk + "\t");
//            }
//            System.out.println();
//        }

        System.out.println(max);
    }
}
