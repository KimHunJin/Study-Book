public class BellmanFord {

    public static final int INFINITY = 1000;

    public static void main(String[] args) {

        int size = 6;

        int[] A = {0, 0, 2, 5, 1, INFINITY, INFINITY};
        int[] B = {0, 2, 0, 3, 2, INFINITY, INFINITY};
        int[] C = {0, 5, 3, 0, 3, 1, 5};
        int[] D = {0, 1, 2, 3, 0, 1, INFINITY};
        int[] E = {0, INFINITY, INFINITY, 1, 1, 0, 2};
        int[] F = {0, INFINITY, INFINITY, 5, INFINITY, 2, 0};

        int[][] map = new int[size + 1][size + 1];

        map[1] = A;
        map[2] = B;
        map[3] = C;
        map[4] = D;
        map[5] = E;
        map[6] = F;

        for (int[] r : map) {
            for (int s : r) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

        System.out.println();

        int[][] result = bellmanFord(map);


        System.out.println("BellmanFord");
        System.out.println("===============");
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map.length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map.length; j++) {
                if(i==j) {
                    continue;
                } else {
                    System.out.println(i + " -> " + j + " : " + result[i][j]);
                }
            }
        }

    }

    public static int[][] bellmanFord(int[][] map) {
        int min;
        int size = map.length;

        boolean[][] isVisible = new boolean[size][size];
        int[][] cost = new int[size][size];


        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                if (i == j) {
                    cost[i][j] = 0;
                } else {
                    cost[i][j] = map[i][j];
                    map[i][j] = INFINITY;
                }
            }
        }

        boolean isFinish = false;

        while (!isFinish) {
            for (int i = 1; i < size; i++) {
                for (int j = 1; j < size; j++) {
                    min = INFINITY;
                    for (int k = 1; k < size; k++) {
                        int co = cost[i][k];
                        int mp = map[k][j];
                        if (co + mp < min) {
                            min = co + mp;
                        }
                    }
                    if (map[i][j] == min) {
                        isVisible[i][j] = true;
                    }
                    map[i][j] = min;
                }
            }
            for (int i = 1; i < size; i++) {
                for (int j = 1; j < size; j++) {
                    if (!isVisible[i][j]) {
                        isFinish = false;
                        break;
                    }
                    isFinish = true;
                }
                if (!isFinish) {
                    break;
                }
            }
        }

        return map;
    }
}
