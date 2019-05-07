package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2309 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] n = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            n[i] = Integer.parseInt(br.readLine(), 10);
            sum += n[i];
        }

        Arrays.sort(n);

        sum -= 100;

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (n[i] + n[j] == sum) {
                    print(i, j, n);
                    return;
                }
            }
        }
    }

    static void print(int a, int b, int[] n) {
        for (int i = 0; i < 9; i++) {
            if(i!=a && i!=b) {
                System.out.println(n[i]);
            }
        }
    }
}
