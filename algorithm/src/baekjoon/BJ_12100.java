package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_12100 {
    public static void main(String[] args) {
        new BJ_12100().solve();
    }

    private enum DIR {
        TOP,
        DOWN,
        LEFT,
        RIGHT
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[][] map = makeMap(br);
            int row = map.length;
            int col = map[0].length;
            List<DIR> d = new ArrayList<>();
            d.add(DIR.TOP);
            d.add(DIR.DOWN);
            d.add(DIR.RIGHT);
            d.add(DIR.LEFT);

            for (DIR dir : d) {
                System.out.println(dir);
                System.out.println("-----------");
                int[][] newMap = new int[row][col];
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        newMap[i][j] = map[i][j];
                    }
                }
                print(sum(move(newMap,dir), dir));
            }

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private int[][] move(int[][] map, DIR d) {
        int row = map.length;
        int col = map[0].length;
        switch (d) {
            case TOP: {
                for (int i = 0; i < col; i++) {
                    for (int j = 0; j < row; j++) {
                        if (map[j][i] != 0) {
                            // index가 0이거나 어떤 수가 있을 때 까지 올린다.
                            int k = j - 1;
                            while (true) {
                                if (k < 0) {
                                    k++;
                                    break;
                                }
                                if (map[k][i] == 0) {
                                    k--;
                                } else {
                                    k++;
                                    break;
                                }
                            }
                            if (k >= 0 && j != k) {
                                map[k][i] = map[j][i];
                                map[j][i] = 0;
                            }
                        }
                    }
                }
                break;
            }
            case DOWN: {
                for (int i = 0; i < col; i++) {
                    for (int j = row - 1; j >= 0; j--) {
                        if (map[j][i] != 0) {
                            int k = j + 1;
                            while (true) {
                                if (k >= row) {
                                    k--;
                                    break;
                                }
                                if (map[k][i] == 0) {
                                    k++;
                                } else {
                                    k--;
                                    break;
                                }
                            }
                            if (k < row && j != k) {
                                map[k][i] = map[j][i];
                                map[j][i] = 0;
                            }
                        }
                    }
                }
                break;
            }
            case LEFT: {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if (map[i][j] != 0) {
                            int k = j - 1;
                            while (true) {
                                if (k < 0) {
                                    k++;
                                    break;
                                }
                                if (map[i][k] == 0) {
                                    k--;
                                } else {
                                    k++;
                                    break;
                                }
                            }
                            if (k >= 0 && k != j) {
                                map[i][k] = map[i][j];
                                map[i][j] = 0;
                            }
                        }

                    }
                }
                break;
            }
            case RIGHT: {
                for (int i = 0; i < row; i++) {
                    for (int j = col - 1; j >= 0; j--) {
                        if (map[i][j] != 0) {
                            int k = j + 1;
                            while (true) {
                                if (k >= col) {
                                    k--;
                                    break;
                                }
                                if (map[i][k] == 0) {
                                    k++;
                                } else {
                                    k--;
                                    break;
                                }
                            }
                            if (k < row && k != j) {
                                map[i][k] = map[i][j];
                                map[i][j] = 0;
                            }
                        }
                    }
                }
                break;
            }
        }
        return map;
    }

    private int[][] sum(int[][] map, DIR d) {
        int row = map.length;
        int col = map[0].length;

        switch (d) {
            case TOP: {
                for (int i = 0; i < col; i++) {
                    for (int j = 0; j < row - 1; j++) {
                        if (map[j][i] != 0 && map[j][i] == map[j + 1][i]) {
                            map[j][i] = map[j][i] * 2;
                            map[j + 1][i] = 0;
                        }
                    }
                }
                break;
            }
            case DOWN: {
                for (int i = 0; i < col; i++) {
                    for (int j = row - 1; j > 0; j--) {
                        if (map[j][i] != 0 && map[j][i] == map[j - 1][i]) {
                            map[j][i] = map[j][i] * 2;
                            map[j - 1][i] = 0;
                        }
                    }
                }
                break;
            }
            case RIGHT: {
                for (int i = 0; i < row; i++) {
                    for (int j = col - 1; j > 0; j--) {
                        if (map[i][j] != 0 && map[i][j] == map[i][j - 1]) {
                            map[i][j] = map[i][j] * 2;
                            map[i][j - 1] = 0;
                        }
                    }
                }
                break;
            }
            case LEFT: {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col - 1; j++) {
                        if (map[i][j] != 0 && map[i][j] == map[i][j + 1]) {
                            map[i][j] = map[i][j] * 2;
                            map[i][j + 1] = 0;
                        }
                    }
                }
                break;
            }
        }
        return move(map, d);
    }

    private void print(int[][] map) {
        for (int a[] : map) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    private int[][] makeMap(BufferedReader br) {
        int n = iRead(br);
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] dmp = input(br).split(" ");
            for (int j = 0; j < dmp.length; j++) {
                map[i][j] = convertInt(dmp[j]);
            }
        }
        return map;
    }

    private int convertInt(String s) {
        return Integer.parseInt(s);
    }

    private int iRead(BufferedReader br) {
        return Integer.parseInt(input(br));
    }

    private String input(BufferedReader br) {
        String s = "";
        try {
            s = br.readLine();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return s;
    }

}
