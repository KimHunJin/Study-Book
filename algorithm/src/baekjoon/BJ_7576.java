package baekjoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BJ_7576 {
    class XY {
        public int x;
        public int y;

        XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        new BJ_7576().solve();
    }

    private int m;
    private int n;

    private int[][] box;
    private int[][] values;
    private int result;
    private int max;
    private int ripe;

    private Queue<XY> queue = new ArrayDeque<>();

    private int[] dicX = {1, -1, 0, 0};
    private int[] dicY = {0, 0, 1, -1};

    private void solve() {
        input();
        if (max > 0) {
            find();
        } else {
            System.out.println(-1);
            return;
        }
        if (max == ripe) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    private void find() {

        if (max == ripe) {
            return;
        }

        while (!queue.isEmpty()) {
            XY xy = queue.poll();
            int x = xy.x;
            int y = xy.y;

            result = values[x][y];

            for (int i = 0; i < 4; i++) {
                int nextX = x + dicX[i];
                int nextY = y + dicY[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (values[nextX][nextY] == -1 && box[nextX][nextY] == 0) {
                        values[nextX][nextY] = values[x][y] + 1;
                        ripe++;
                        queue.add(new XY(nextX, nextY));
                    }
                }
            }
        }
    }

    private void input() {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        box = new int[n][m];
        values = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int k = sc.nextInt();
                values[i][j] = -1;
                if (k == 1) {
                    queue.add(new XY(i, j));
                    ripe++;
                    max++;
                    values[i][j] = 0;
                } else if (k == 0) {
                    max++;
                }
                box[i][j] = k;

            }
        }
    }

    private void print() {
        print(box);
        print(values);
        System.out.println("max : " + max + " , ripe : " + ripe);
        System.out.println("result : " + result);
    }

    private void print(int[][] map) {
        for (int x[] : map) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
