package prev;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class C {

    static boolean[][] isCheck;

    static class Board {
        int w;
        int h;
        int weight;

        Board(int w, int h, int weight) {
            this.w = w;
            this.h = h;
            this.weight = weight;

        }
    }

    static Queue<Board> list = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int wSize = Integer.parseInt(input[0]);
        int hSize = Integer.parseInt(input[1]);

        isCheck = new boolean[wSize][hSize];

        list.add(new Board(0, 0, 0));
        int count = 0;

        int[] x = {1, 1, 2, 2, -1, -1, -2, -2};
        int[] y = {2, -2, 1, -1, 2, -2, 1, -1};

        int lastWeight = 0;

        while (!list.isEmpty()) {
            int w = list.peek().w;
            int h = list.peek().h;

            lastWeight = list.peek().weight;

            if (!isCheck[w][h]) {
                isCheck[w][h] = true;
                count++;
                int weight = list.peek().weight;
                for (int i = 0; i < x.length; i++) {
                    if(w + x[i] >= 0 && h + y[i] >=0 && w + x[i] < wSize && h + y[i] < hSize) {
                        list.add(new Board(w + x[i], h + y[i], weight + 1));
                    }
                }
            }
            list.poll();
        }

        String result = "";

        if(count == wSize * hSize) {
            result += "T";
        } else {
            result += "F";
        }

        lastWeight --;

        result += lastWeight;
        System.out.println(result);
    }


}
