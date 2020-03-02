package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_6087 {
    public static void main(String[] args) {
        new BJ_6087().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[] tmp = br.readLine().split(" ");
            int n = Integer.parseInt(tmp[1]);
            int m = Integer.parseInt(tmp[0]);

            int[][] map = new int[n][m];

            int[][] dp = new int[n][m];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], 100001);
            }

            Queue<C> queue = new ArrayDeque<>();

            List<C> list = new ArrayList<>();

            int s = 1;
            for (int i = 0; i < n; i++) {
                String[] k = br.readLine().split("");
                for (int j = 0; j < m; j++) {

                    switch (k[j]) {
                        case "*": {
                            map[i][j] = -1;
                            break;
                        }
                        case ".": {
                            map[i][j] = 0;
                            break;
                        }
                        case "LineD": {
                            map[i][j] = s;
                            s++;
                            list.add(new C(i, j));
                        }
                    }
                }
            }

            int startX = list.get(0).x;
            int startY = list.get(0).y;

            dp[startX][startY] = -1;

            queue.add(new C(startX, startY));
            int endX = list.get(1).x;
            int endY = list.get(1).y;

            int[] dirX = {0, 0, 1, -1};
            int[] dirY = {1, -1, 0, 0};

            while (!queue.isEmpty()) {
                C c = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int staticX = c.x;
                    int staticY = c.y;
                    int x = c.x;
                    int y = c.y;
                    while (true) {
                        int nextX = x + dirX[i];
                        int nextY = y + dirY[i];

                        if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                            break;
                        }

                        if (map[nextX][nextY] == -1) {
                            break;
                        }

                        if (dp[nextX][nextY] < dp[staticX][staticY] + 1) {
                            break;
                        }

                        if (dp[nextX][nextY] >= dp[staticX][staticY] + 1) {
//                            System.out.println("input : " + x + " : " + y);
                            dp[nextX][nextY] = dp[staticX][staticY] + 1;
                            x = nextX;
                            y = nextY;
                            queue.add(new C(x, y));
                        }
                    }
                }
            }

//            System.out.println("map");
//            print(map);

//            System.out.println("dp");
//            print(dp);

            System.out.println(dp[endX][endY]);

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private void print(int[][] map) {
        for(int m[]: map) {
            for(int n: m) {
                System.out.print(n + "\t");
            }
            System.out.println();
        }
    }

    class C {
        int x;
        int y;

        C(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
