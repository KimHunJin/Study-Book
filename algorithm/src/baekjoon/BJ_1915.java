package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1915 {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] dmp = br.readLine().split(" ");
            int m = Integer.parseInt(dmp[0]);
            int n = Integer.parseInt(dmp[1]);

            int dp[][] = new int[1001][1001];
            int map[][] = new int[1001][1001];
            int max = 0;

            for (int i = 1; i <= m; i++) {
                String s = br.readLine();
                for (int j = 1; j <= n; j++) {
                    map[i][j] = s.charAt(j - 1) - '0';
                }
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][j] != 0) {
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;
                        max = Math.max(dp[i][j], max);
                    }
                }
            }

            System.out.println(max * max);
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}

