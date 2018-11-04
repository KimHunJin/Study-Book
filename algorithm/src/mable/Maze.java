package mable;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Maze {

    static class Test {
        int[][] board;
        int c;

        Test(int[][] board, int c) {
            this.board = board;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Maze maze = new Maze();

        int[][] a = {
                {0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 3, 0, 0, 0, 1, 0}
        };

        int[][] b = {
                {0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 3, 0, 0, 0, 1, 0}
        };

        List<Test> list = new ArrayList<>();
        list.add(new Test(a, 1));
        list.add(new Test(b, 2));

        for (Test t : list) {
            System.out.println(maze.solution(t.board, t.c));
        }


    }

    public int solution(int[][] board, int c) {
        Dic start = null;
        Dic des = null;

        int[][] map = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 2) {
                    start = new Dic(i, j, 0);
                    map[i][j] = 0;
                }
                if (board[i][j] == 3) {
                    des = new Dic(i, j, 0);
                }
            }
        }


        Queue<Dic> queue = new ArrayDeque<>();
        queue.add(start);


        int max = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Dic d = queue.poll();


            if (map[d.x][d.y] == 0) {
                map[d.x][d.y] = d.weight;
            } else {
                if (map[d.x][d.y] < d.weight) {
                    continue;
                } else {
                    map[d.x][d.y] = d.weight;
                }
            }

            if (d.x == des.x && d.y == des.y) {
                max = max > map[d.x][d.y] ? map[d.x][d.y] : max;
                continue;
            }


            int[] dirX = {0, 0, -1, 1};
            int[] dirY = {1, -1, 0, 0};

            int x = d.x;
            int y = d.y;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dirX[i];
                int nextY = y + dirY[i];

                if (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length) {
                    if (board[nextX][nextY] == 1) {
                        queue.add(new Dic(nextX, nextY, d.weight + 1 + c));
                    } else  {
                        queue.add(new Dic(nextX, nextY, d.weight + 1));
                    }
                }
            }
        }

        return max;
    }

    class Dic {
        int x;
        int y;
        int weight;

        Dic(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
}
