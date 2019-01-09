package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_2573 {
    public static void main(String[] args) {
        new BJ_2573().init();
    }

    class Ice {
        int x;
        int y;
        int weight;

        Ice(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    private int[] tx = {0, 0, 1, -1};
    private int[] ty = {1, -1, 0, 0};

    private void init() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] dump = br.readLine().split(" ");
            int n = convertInt(dump[0]);
            int m = convertInt(dump[1]);
            int[][] map = new int[n][m];
            boolean[][] isIce = new boolean[n][m];
            List<Ice> iceList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                dump = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    map[i][j] = convertInt(dump[j]);
                    if (map[i][j] > 0) {
                        iceList.add(new Ice(i, j, map[i][j]));
                        isIce[i][j] = true;
                    }
                }
            }
            solve(map, iceList, isIce);
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private void solve(int[][] map, List<Ice> iceList, boolean[][] isIce) {
        int count = getGroupCount(isIce, iceList);
        int year = 0;
        while (!iceList.isEmpty() && count < 2) {
            year++;
            int size = iceList.size();
            for (Ice ice : iceList) {
                int x = ice.x;
                int y = ice.y;
                int weight = ice.weight;

                int meltCount = getMeltIceCount(isIce, ice);

                weight = weight - meltCount >= 0 ? weight - meltCount : 0;
                map[x][y] = weight;
                ice.weight = weight;
            }

            for (int i = size - 1; i >= 0; i--) {
                Ice ice = iceList.get(i);
                int x = ice.x;
                int y = ice.y;
                if (ice.weight == 0) {
                    isIce[x][y] = false;
                    iceList.remove(ice);
                }
            }
            count = getGroupCount(isIce, iceList);
        }
        if (iceList.isEmpty() && count < 2) {
            System.out.println(0);
        } else {
            System.out.println(year);
        }
    }

    private int getGroupCount(boolean[][] isIce, List<Ice> iceList) {
        boolean[][] isVisit = new boolean[isIce.length][isIce[0].length];
        int count = 0;

        for (Ice ice : iceList) {
            int x = ice.x;
            int y = ice.y;
            if (isIce[x][y] && !isVisit[x][y]) {
                count++;
                isVisit[x][y] = true;
                for (int i = 0; i < 4; i++) {
                    checkGroup(isIce, x + tx[i], y + ty[i], isVisit);
                }
            }
        }

        return count;
    }

    private void checkGroup(boolean[][] isIce, int x, int y, boolean[][] isVisit) {

        if (isIce[x][y] && !isVisit[x][y]) {
            isVisit[x][y] = true;
            for (int i = 0; i < 4; i++) {
                checkGroup(isIce, x + tx[i], y + ty[i], isVisit);
            }
        }
    }

    private int getMeltIceCount(boolean[][] isIce, Ice ice) {
        int x = ice.x;
        int y = ice.y;

        int count = 0;

        for (int i = 0; i < 4; i++) {
            if (!isIce[x + tx[i]][y + ty[i]]) {
                count++;
            }
        }
        return count;
    }

    private int convertInt(String s) {
        return Integer.parseInt(s, 10);
    }
}
