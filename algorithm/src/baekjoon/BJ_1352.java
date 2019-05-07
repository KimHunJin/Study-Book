package baekjoon;

import java.util.Scanner;

public class BJ_1352 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println("number : " + i);
            new BJ_1352().solve(i);
            System.out.println();
        }
//        new BJ_1352().solve();
    }

    private void solve(int findNum) {
//        Scanner sc = new Scanner(System.in);
//        int findNum = sc.nextInt();

        int n = 0;

        int[] minSum = new int[findNum + 1];
        minSum[0] = 0;

        for (int i = 0; findNum >= (int) (Math.pow(2, i)); i++) {
            n++;
        }

        for (int i = 1; i <= n; i++) {
            minSum[i] = (int)(Math.pow(2,i)-1);
        }


        String[] words = {"", "A", "B", "C", "D", "E", "F", "G", "H", "I"};

        int[] wordsCount = new int[findNum + 1];

        String[] result = new String[findNum + 1];

        for (int i = 0; i < result.length; i++) {
            result[i] = "";
        }

        while (n > 0) {
            if (findNum - minSum[n - 1] <= minSum[n - 1] + 1) {
                wordsCount[n] = findNum - minSum[n - 1];
                result[wordsCount[n]] = words[n];
                wordsCount[n]--;
                findNum = minSum[n - 1];
                n--;
            } else {
                minSum[n - 1]++;
            }
        }

        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < wordsCount.length; j++) {
                if (result[i].equals("")) {
                    if (wordsCount[j] > 0) {
                        result[i] = words[j];
                        wordsCount[j]--;
                    }
                }
            }
        }

        String r = "";

        for (String s : result) {
            r+=s;
        }
        System.out.println(r);
        if(r.length() == result.length-1) {
            System.out.println(r);
        } else {
            System.out.println(-1);
        }

    }
}
