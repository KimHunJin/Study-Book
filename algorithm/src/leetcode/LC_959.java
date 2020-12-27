package leetcode;

public class LC_959 {

    public static void main(String[] args) {
        new LC_959().solve();
    }

    private void solve() {

        //  / -> (x+1, y), (x, y+1)
        // \  -> (x, y), (x+1, y+1)

        String[] grids = {
                " /",
                "/"
        };

        System.out.println(regionsBySlashes(grids));
    }

    int[][] map;

    boolean[][] isVisit;

    public int regionsBySlashes(String[] grid) {

        int size = grid.length;
        map = new int[size + 1][size + 1];
        isVisit = new boolean[size + 1][size + 1];

        for (int i = 0; i < grid.length; i++) {
            String row = grid[i];
            for (int j = 0; j < row.length(); j++) {
                char cell = row.charAt(j);
                drawMap(cell, i, j);
            }
        }

        int region = 0;

        // dfs를 어떻게 하더라.......

        return region;
    }

    // 0으로 이어진 연결된 공간 찾기
    private void findMap(int x, int y) {

    }

    private void drawMap(char cell, int x, int y) {

        switch (cell) {
            case '/': {
                map[x + 1][y] = 1;
                map[x][y + 1] = 1;
                break;
            }
            case '\\': {
                map[x][y] = 1;
                map[x + 1][y + 1] = 1;
                break;
            }
        }
    }
}
