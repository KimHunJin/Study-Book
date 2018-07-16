package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1915
 *
 * n×m의 0, 1로 된 배열이 있다. 이 배열에서 1로 된 가장 큰 정사각형의 크기를 구하는 프로그램을 작성하시오.
 *
 * 0	1	0	0
 * 0	1	1	1
 * 1	1	1	0
 * 0	0	1	0
 *
 * 위와 같은 예제에서는 가운데의 2×2 배열이 가장 큰 정사각형이다.
 *
 * ex)
 * input
 * 4 4
 * 0100
 * 0111
 * 1110
 * 0010
 *
 * output
 * 4
 *
 * solution
 * DP (Dynamic Programming)
 *
 */
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

