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
//        for (int i = 1; i <= 100; i++) {
        list = new ArrayList<>();
        int currentSum = 0;
        int start = 0;
        find(findSum, currentSum, start, "");

        Collections.sort(list);
        if (list.size() > 0) {
            System.out.println(list.get(0));
        } else {
            System.out.println(0);
        }

    }

    private void find(int findSum, int currentSum, int start, String string) {

        int startIndex = start;
        int lastIndex = currentSum + 1;
        String tmp = string;
        for (int i = startIndex; i <= lastIndex; i++) {
            if (currentSum > findSum) {
                return;
            } else if (currentSum == findSum) {
                string = string.trim();
                String[] c = string.split(" ");


                int size = c.length;
                int[] cn = new int[size]; // 1 2 3 5
                String[] result = new String[findSum];
                char[] word = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N'};

                for (int j = 0; j < size; j++) {
                    cn[j] = Integer.parseInt(c[j]);
                    if (cn[j] == 0) {
                        return;
                    }

                    result[cn[j] - 1] = word[j] + "";
                    cn[j]--;
                }

                String r = "";
                for (int j = 0; j < result.length; j++) {
                    if (result[j] == null) {
                        for (int k = 0; k < size; k++) {
                            if (cn[k] > 0) {
                                result[j] = word[k] + "";
                                cn[k]--;
                                break;
                            }
                        }
                    }
                    r += result[j];
                }
                list.add(r);
                return;
            } else {
                int sum = currentSum + i;
                find(findSum, sum, 1 + i, tmp + " " + i);
            }
        }
    }
}
