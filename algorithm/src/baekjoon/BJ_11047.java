package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11047 {
    public static void main(String[] args) {
        new BJ_11047().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tmp = br.readLine().split(" ");
            int n = Integer.parseInt(tmp[0], 10);
            int won = Integer.parseInt(tmp[1], 10);

            int[] coin = new int[n];
            int startIndex = n - 1;

            for (int i = 0; i < n; i++) {
                coin[i] = Integer.parseInt(br.readLine(), 10);
                if (coin[i] > won) {
                    startIndex = i - 1;
                    break;
                }
            }

            int count = 0;
            for (int i = startIndex; i >= 0; i--) {
                count += won / coin[i];
                won = won % coin[i];
            }

            System.out.println(count);

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
