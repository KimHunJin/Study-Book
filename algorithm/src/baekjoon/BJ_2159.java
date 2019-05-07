package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BJ_2159 {
    public static void main(String[] args) {

    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine(), 10);
            String tmp[] = br.readLine().split(" ");
            int startXY[] = {
                    Integer.parseInt(tmp[0]),
                    Integer.parseInt(tmp[1])
            };

            int[][] destinationXY = new int[n][2];
            for (int i = 0; i < n; i++) {
                tmp = br.readLine().split(" ");
                destinationXY[i][0] = Integer.parseInt(tmp[0]);
                destinationXY[i][1] = Integer.parseInt(tmp[1]);
            }


        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private int shortestDis(int[] startXY, int[][] destinationXY, int index, int distance) {

        int startX = startXY[0];
        int startY = startXY[1];

        int nextX = destinationXY[index][0];
        int nextY = destinationXY[index][1];

        if (startX == nextX) {
            if (startY > nextY) {
                int[] nextXY = {nextX, nextY + 1};
                return shortestDis(nextXY, destinationXY, index + 1, Math.abs(nextY - startY));
            }
            if (startY == nextY) {
            }
        }

        if (index == destinationXY.length) {
            return distance;
        }

        return 0;
    }
}
