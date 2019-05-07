package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2798 {
    public static void main(String[] args) {
        new BJ_2798().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tmp = br.readLine().split(" ");
            int n = Integer.parseInt(tmp[0], 10);
            int m = Integer.parseInt(tmp[1], 10);

            tmp = br.readLine().split(" ");
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(tmp[i], 10);
            }

            Arrays.sort(numbers);

            int max = 0;
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        int sum = numbers[i] + numbers[j] + numbers[k];
                        if (sum < m) {
                            if (max < sum) {
                                max = sum;
                            }
                        } else if (sum == m) {
                            System.out.println(sum);
                            return;
                        } else {
                            break;
                        }
                    }
                }
            }

            System.out.println(max);

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
