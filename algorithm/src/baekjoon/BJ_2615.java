package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2615 {

    public static void main(String[] args) {
        new BJ_2615().solution();
    }

    // D R LD RD
    int[] moveY = {0, 1, -1, 1};
    int[] moveX = {1, 0, 1, 1};

    int[] reverseY = {0, -1, 1, -1};
    int[] reverseX = {-1, 0, -1, -1};

    int[][] input;

    void solution() {
        input = new int[19][19];

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            for (int i = 0; i < 19; i++) {
                String s = br.readLine();
                String[] split = s.split(" ");
                for (int j = 0; j < split.length; j++) {
                    input[i][j] = Integer.parseInt(split[j]);
                }
            }

        } catch (IOException ie) {
            ie.printStackTrace();
        }

        solve();
    }

    private void solve() {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (input[i][j] == 1) {
                    if (find(1, i, j)) {
                        return;
                    }
                } else if (input[i][j] == 2) {
                    if(find(2, i, j)) {
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    private boolean find(int color, int x, int y) {
        boolean isFind;
        for (int dic = 0; dic < 4; dic++) {
            if (isStart(color, dic, x, y)) {
                isFind = find(color, dic, 1, x, y);
                if (isFind) {
                    System.out.println(color);
                    if (dic == 2) {
                        x = x + 4;
                        y = y - 4;
                    }
                    System.out.println((x + 1) + " " + (y + 1));
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isStart(int color, int dic, int x, int y) {
        int checkX = x + reverseX[dic];
        int checkY = y + reverseY[dic];

        if (checkX < 0 || checkY < 0) {
            return true;
        }

        if (checkX >= 19 || checkY >= 19) {
            return true;
        }

        return input[checkX][checkY] != color;
    }

    private boolean find(int color, int dic, int n, int x, int y) {

        if (n > 5) {
            return false;
        }

        int movingX = x + moveX[dic];
        int movingY = y + moveY[dic];

        if (movingX < 0 || movingY < 0) {
            return n == 5;
        }

        if (movingX >= 19 || movingY >= 19) {
            return n == 5;
        }

        if (input[movingX][movingY] == color) {
            return find(color, dic, n + 1, movingX, movingY);
        }

        return n == 5;
    }
}
