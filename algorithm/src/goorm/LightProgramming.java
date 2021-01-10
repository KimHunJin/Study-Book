package goorm;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

        Map<Integer, Integer> lampMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            int type = Integer.parseInt(temp[0]);
            int index = Integer.parseInt(temp[1], 10) - 1;
            if (type == HORIZONTAL) {
                // 가로는 index * 100 + 1 * n
                for (int k = 0; k < col; k++) {
                    int indexNumber = (index * 100) + k;
                    if (lampMap.containsKey(indexNumber)) {
                        lampMap.put(indexNumber, lampMap.get(indexNumber) + 1);
                    } else {
                        lampMap.put(indexNumber, 1);
                    }
//                    lamps[index][k] = lamps[index][k] == 0 ? 1 : 0;
                }
            } else {
                // 세로는 index + 100 * n
                for (int k = 0; k < row; k++) {
                    int indexNumber = (k * 100) + index;
                    if (lampMap.containsKey(indexNumber)) {
                        lampMap.put(indexNumber, lampMap.get(indexNumber) + 1);
                    } else {
                        lampMap.put(indexNumber, 1);
                    }
                }
            }
        }

        Set<Integer> s = lampMap.keySet();
        for (int key : s) {
            int calRow = key / 100;
            int calCol = key % 100;
            int count = lampMap.get(key);

            if (count % 2 == 1) {
                lamps[calRow][calCol] = lamps[calRow][calRow] == 0 ? 1 : 0;
            }
        }


        for (int[] lamp : lamps) {
            for (int light : lamp) {
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
