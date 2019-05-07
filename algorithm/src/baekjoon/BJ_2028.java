package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2028 {
    public static void main(String[] args) {
        new BJ_2028().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine(), 10);
            while (n-- > 0) {
                String s = br.readLine();
                int length = s.length();
                int k = Integer.parseInt(s, 10);
                int kk = k * k;

                int m = (int) (Math.pow(10, length));

                if (k == kk % m) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
