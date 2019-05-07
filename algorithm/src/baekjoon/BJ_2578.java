package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ_2578 {

    class XY {
        int x;
        int y;

        XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        new BJ_2578().solve();
    }

    boolean isCall[][] = new boolean[5][5];

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[][] board = new int[5][5];

            Map<Integer, XY> map = new HashMap<>();
            for (int i = 0; i < 5; i++) {
                String[] tmp = br.readLine().split(" ");
                for (int j = 0; j < 5; j++) {
                    int n = Integer.parseInt(tmp[j]);
                    board[i][j] = n;
                    map.put(n, new XY(i, j));
                }
            }

            int count = 0;

            int bingo = 0;
            for (int i = 0; i < 5; i++) {
                String[] tmp = br.readLine().split(" ");
                for (int j = 0; j < 5; j++) {
                    int n = Integer.parseInt(tmp[j]);
                    XY xy = map.get(n);
                    int x = xy.x;
                    int y = xy.y;
                    isCall[x][y] = true;
                    count++;
                    bingo += isBingo(x, y);
                    if(bingo >= 3) {
                        System.out.println(count);
                        return;
                    }
                }
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private int isBingo(int x, int y) {
        int count = 0;
        if (x == y) {
            boolean isFind = true;
            for (int i = 0; i < 5; i++) {
                if (!isCall[i][i]) {
                    isFind = false;
                    break;
                }
            }
            if (isFind) {
                count++;
            }
        }

        if (x + y == 4) {
            boolean isFind = true;
            for (int i = 0; i < 5; i++) {
                if (!isCall[i][4 - i]) {
                    isFind = false;
                    break;
                }
            }
            if (isFind) {
                count++;
            }
        }

        boolean isFind = true;
        for (int i = 0; i < 5; i++) {
            if (!isCall[i][y]) {
                isFind = false;
                break;
            }
        }
        if (isFind) {
            count++;
        }

        isFind = true;
        for (int i = 0; i < 5; i++) {
            if(!isCall[x][i]) {
                isFind = false;
                break;
            }
        }
        if(isFind) {
            count++;
        }

        return count;
    }
}
