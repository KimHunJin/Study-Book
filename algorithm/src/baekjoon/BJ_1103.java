package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1103 {
    public static void main(String[] args) {
        new BJ_1103().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tmp = br.readLine().split(" ");
            int n = Integer.parseInt(tmp[0], 10);
            int m = Integer.parseInt(tmp[1], 10);

            int[][] map = new int[n][m];
            boolean[][] isVisit = new boolean[n][m];

            int[] moveX = {0, 0, -1, 1};
            int[] moveY = {1, -1, 0, 0};

            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < m; j++) {
                    char c = s.charAt(j);
                    if (c == 'H') {
                        map[i][j] = -500;
                    } else {
                        map[i][j] = s.charAt(j) - '0';
                    }
                }
            }

            Queue<Game> q = new ArrayDeque<>();
            Game init = new Game(0, 0, map[0][0], 0, isVisit);
            q.add(init);

            boolean isInfinity = false;

            int result = 0;

            while (!q.isEmpty()) {
                Game p = q.poll();
                int x = p.x;
                int y = p.y;
                int number = p.number;
                int count = p.count;

                if (map[x][y] == -500) {
                    count--;
                }

                if (result < count) {
                    result = count;
                }

                for (int i = 0; i < moveX.length; i++) {
                    int nextX = x + (moveX[i] * number);
                    int nextY = y + (moveY[i] * number);

                    if (nextX < n && nextY < m && nextX >= 0 && nextY >= 0) {
                        if (p.isVisit[nextX][nextY]) {
                            isInfinity = true;
                            break;
                        } else {
                            int nextCount = count + 1;
                            Game nextP = new Game(nextX, nextY, map[nextX][nextY], nextCount, isVisitCopy(isVisit));
                            q.add(nextP);
                        }
                    }
                }
                if (isInfinity) {
                    break;
                }
            }

            if (isInfinity) {
                System.out.println(-1);
            } else {
                System.out.println(result + 1);
            }

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private boolean[][] isVisitCopy(boolean[][] isVisit) {
        boolean[][] copy = new boolean[isVisit.length][isVisit[0].length];
        for (int i = 0; i < isVisit.length; i++) {
            System.arraycopy(isVisit[i], 0, copy[i], 0, isVisit[i].length);
        }
        return copy;
    }

    class Game {
        int x;
        int y;
        int number;
        int count;
        boolean[][] isVisit;

        Game(int x, int y, int number, int count, boolean[][] isVisit) {
            this.x = x;
            this.y = y;
            this.number = number;
            this.count = count;
            this.isVisit = isVisit;
            isVisit[x][y] = true;
        }
    }
}
