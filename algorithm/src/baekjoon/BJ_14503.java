package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_14503 {
    public static void main(String[] args) {
        new BJ_14503().solve();
    }

    private int[] init = {3, 1, 0, 2};

    private int[] moveX = {0, -1, 0, 1}; // 좌 하 우 상
    private int[] moveY = {-1, 0, 1, 0};

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[] tmp = br.readLine().split(" ");
            int n = Integer.parseInt(tmp[0], 10);
            int m = Integer.parseInt(tmp[1], 10);

            int[][] map = new int[n][m];

            tmp = br.readLine().split(" ");
            int startX = Integer.parseInt(tmp[0], 10);
            int startY = Integer.parseInt(tmp[1], 10);
            int dic = Integer.parseInt(tmp[2], 10);

            for (int i = 0; i < n; i++) {
                tmp = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(tmp[j], 10);
                }
            }

            for (int[] a : map) {
                for (int b : a) {
                    System.out.print(b + " ");
                }
                System.out.println();
            }

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
