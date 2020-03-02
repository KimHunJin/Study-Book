package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9324 {
    public static void main(String[] args) {
        new BJ_9324().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine(), 10);


            while (n-- > 0) {
                int[] count = new int[26];
                String s = br.readLine();
                boolean isFake = false;

                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    count[c - 'A']++;
                    if (count[c - 'A'] % 3 == 0) {
                        i++;
                        if (i >= s.length() || c != s.charAt(i)) {
                            isFake = true;
                            break;
                        }
                    }
                }
                if (isFake) {
                    System.out.println("FAKE");
                } else {
                    System.out.println("OK");
                }
            }

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
