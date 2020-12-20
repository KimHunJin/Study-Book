package goorm;

import java.io.*;

public class LightProgramming {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;

    public static void main(String[] args) throws Exception {
        new LightProgramming().solve();
    }

    private void solve() throws Exception {
        String input = br.readLine();
        String[] colWithRow = input.split(" ");

        int row = Integer.parseInt(colWithRow[0], 10);
        int col = Integer.parseInt(colWithRow[1], 10);

        int[][] lamps = makeLamp(row, col);

        int n = Integer.parseInt(br.readLine(), 10);

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            int type = Integer.parseInt(temp[0]);
            int index = Integer.parseInt(temp[1], 10) - 1;
            if (type == HORIZONTAL) {
                for (int k = 0; k < col; k++) {
                    lamps[index][k] = lamps[index][k] == 0 ? 1 : 0;
                }
            } else {
                for (int k = 0; k < row; k++) {
                    lamps[k][index] = lamps[k][index] == 0 ? 1 : 0;
                }
            }
        }

        for (int[] lamp: lamps) {
            for (int light: lamp) {
                System.out.print(light + " ");
            }
            System.out.println();
        }
    }

    private int[][] makeLamp(int row, int col) throws Exception {
        int[][] lamp = new int[row][col];

        for (int i = 0; i < row; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                lamp[i][j] = Integer.parseInt(inputs[j], 10);
            }
        }

        return lamp;
    }
}
