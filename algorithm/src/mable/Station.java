package mable;

import java.util.*;

public class Station {

    static class Test {
        int N;
        int[][] bus_stop;

        Test(int N, int[][] bus_stop) {
            this.N = N;
            this.bus_stop = bus_stop;
        }
    }

    public static void main(String[] args) {
        Station station = new Station();

        List<Test> list = new ArrayList<>();

        int a[][] = {{1, 2}};
        int b[][] = {{1, 2}, {3, 3}};

        list.add(new Test(3, a));
        list.add(new Test(3, b));

        for (Test t : list) {
            station.output(station.solution(t.N, t.bus_stop));
        }
    }

    private void output(int[][] map) {
        for (int a[] : map) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[][] solution(int N, int[][] bus_stop) {
        int[][] answer = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(answer[i], Integer.MAX_VALUE);
        }

        Queue<Stop> queue = new ArrayDeque<>();

        for (int i = 0; i < bus_stop.length; i++) {
            Stop stop = new Stop(bus_stop[i][0] - 1, bus_stop[i][1] - 1, 0);
            answer[stop.x][stop.y] = 0;
            queue.add(stop);
        }

        int[] x = {0, 0, 1, -1};
        int[] y = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            Stop stop = queue.poll();
            int stopX = stop.x;
            int stopY = stop.y;

            answer[stopX][stopY] = answer[stopX][stopY] > stop.dis ? stop.dis : answer[stopX][stopY];

            int dis = stop.dis + 1;

            for (int i = 0; i < 4; i++) {
                int nextX = stopX + x[i];
                int nextY = stopY + y[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    if (answer[nextX][nextY] > dis) {
                        queue.add(new Stop(nextX, nextY, dis));
                    }
                }
            }
        }

        return answer;
    }

    class Stop {
        int x;
        int y;
        int dis;

        Stop(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}
