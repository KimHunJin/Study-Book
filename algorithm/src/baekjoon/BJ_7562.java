package baekjoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BJ_7562 {
    private Scanner sc;
    private int size;

    private int[] dicX = {-1, -1, 1, 1, -2, -2, 2, 2};
    private int[] dicY = {-2, 2, -2, 2, -1, 1, -1, 1};

    private int[][] map;
    private int[][] count;

    private Queue<XY> queue;

    private XY start;
    private XY end;

    public static void main(String[] args) {
        new BJ_7562().solve();
    }

    private void solve() {
        sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            input();
            check();
        }
    }

    private void input() {
        queue = new ArrayDeque<>();
        size = sc.nextInt();
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int endX = sc.nextInt();
        int endY = sc.nextInt();

        map = new int[size][size];
        count = new int[size][size];

        start = new XY(startX, startY);
        end = new XY(endX, endY);

        count[startX][startY] = 1;
        map[startX][startY] = 1;

        queue.add(start);
    }

    private void check() {
        while (!queue.isEmpty()) {

            XY xy = queue.poll();
            int x = xy.x;
            int y = xy.y;

            if(x == end.x && y == end.y) {
                System.out.println(count[x][y]-1);
                break;
            }

            for (int i = 0; i < dicX.length; i++) {
                int nx = x + dicX[i];
                int ny = y + dicY[i];

                if (nx >= 0 && nx < size && ny >= 0 && ny < size) {
                    if (count[nx][ny] == 0) {
                        count[nx][ny] = count[x][y] + 1;
                        queue.add(new XY(nx, ny));
                    }
                }
            }
        }
    }

    class XY {
        int x;
        int y;

        XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
