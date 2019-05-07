package woowah;

public class House {
    public static void main(String[] args) {
        new House().solve();
    }

    private void solve() {
        int[][] lands = {
                {10, 0, 30, 5},
                {0, 30, 20, 50},
                {30, 30, 40, 40}
        };

        int[][] wells = {
                {15, 15, 25, 25},
                {40, 10, 50, 20}
        };

        int[] point = {10, 10, 30, 30};


        int[][] lands2 = {
                {0, 0, 20, 10},
                {10, 20, 20, 40},
                {30, 0, 50, 20}
        };

        int[][] wells2 = {
                {15, 15, 25, 25},
                {40, 10, 50, 20}
        };

        int[] point2 = {20, 30, 30, 40};

        System.out.println(isCheck(lands, wells, point));
    }


    private boolean isCheck(int[][] lands, int[][] wells, int[] point) {

        int pointStartX = point[0];
        int pointStartY = point[1];

        int pointEndX = point[2];
        int pointEndY = point[3];

        int x = pointStartX * 10 + pointStartY;

        int y = pointEndX * 10 + pointEndY;


        int n = Math.abs(pointEndX - pointStartX);
        int m = Math.abs(pointEndY - pointStartY);

        int[][] map = new int[n][m];


        for (int i = 0; i < lands.length; i++) {
            int landStartX = lands[i][0];
            int landStartY = lands[i][1];
            int landEndX = lands[i][2];
            int landEndY = lands[i][3];

            int lx = landStartX * 10 + landStartY;
            int ly = landEndX * 10 + landEndY;


            if (lx > x && lx < y) {
                System.out.println(lx + " : " + x + " : " + y);
                System.out.println("false1");
                return false;
            }
            if (ly > x && ly < y) {
                System.out.println(ly + " : " + x + " : " + y);
                System.out.println("false2");
                return false;
            }
        }


        for (int i = 0; i < wells.length; i++) {
            int wellStartX = wells[i][0];
            int wellStartY = wells[i][1];
            int wellEndX = wells[i][2];
            int wellEndY = wells[i][3];

            int lx = wellStartX * 10 + wellStartY;
            int ly = wellEndX * 10 + wellEndY;


            if (lx < x && lx > y) {
                System.out.println("false3");
                return false;
            }
            if (ly < x && ly > y) {
                System.out.println("false4");
                return false;
            }
        }
        return true;


    }


    private void test(int[][] lands, int[][] wells, int[] point) {
        int pointStartX = point[0];
        int pointStartY = point[1];

        int pointEndX = point[2];
        int pointEndY = point[3];


        int n = Math.abs(pointEndX - pointStartX);
        int m = Math.abs(pointEndY - pointStartY);

        int[][] map = new int[n][m];
        for (int i = 0; i < lands.length; i++) {
            int landStartX = lands[i][0];
            int landStartY = lands[i][1];
            int landEndX = lands[i][2];
            int landEndY = lands[i][3];

            if (landStartX < pointStartX) {
                landStartX = pointStartX;
            } else if (landStartX > pointEndX) {
                landStartX = pointEndX;
            }

            if (landStartY < pointStartY) {
                landStartY = pointStartY;
            } else if (landStartY > pointEndY) {
                landStartY = pointEndY;
            }

            if (landEndX < pointStartX) {
                landEndX = pointStartX;
            } else if (landEndX > pointEndX) {
                landEndX = pointEndX;
            }

            if (landEndY < pointStartY) {
                landEndY = pointStartY;
            } else if (landEndY > pointEndY) {
                landEndY = pointEndY;
            }

            landStartX = landStartX - pointStartX;
            landStartY = landStartY - pointStartY;
            landEndX = landEndX - pointStartX;
            landEndY = landEndY - pointStartY;

            System.out.println("land x : " + landStartX + " y : " + landStartY + "\nx : " + landEndX + " y : " + landEndY);

            for (int j = landStartX; j < landEndX; j++) {
                for (int k = landStartY; k < landEndY; k++) {
                    map[j][k] = -1;
                }
            }
        }

        for (int i = 0; i < wells.length; i++) {
            int wellStartX = wells[i][0];
            int wellStartY = wells[i][1];
            int wellEndX = wells[i][2];
            int wellEndY = wells[i][3];

            if (wellStartX < pointStartX) {
                wellStartX = pointStartX;
            } else if (wellStartX > pointEndX) {
                wellStartX = pointEndX;
            }

            if (wellStartY < pointStartY) {
                wellStartY = pointStartY;
            } else if (wellStartY > pointEndY) {
                wellStartY = pointEndY;
            }

            if (wellEndX < pointStartX) {
                wellEndX = pointStartX;
            } else if (wellEndX > pointEndX) {
                wellEndX = pointEndX;
            }

            if (wellEndY < pointStartY) {
                wellEndY = pointStartY;
            } else if (wellEndY > pointEndY) {
                wellEndY = pointEndY;
            }

            wellStartX = wellStartX - pointStartX;
            wellStartY = wellStartY - pointStartY;
            wellEndX = wellEndX - pointEndX;
            wellEndY = wellEndY - pointEndY;

            System.out.println("well x : " + wellStartX + " y : " + wellStartY + "\nx : " + wellEndX + " y : " + wellEndY);


            for (int j = wellStartX; j < wellEndX; j++) {
                for (int k = wellStartY; k < wellEndY; k++) {
                    map[j][k] = 2;
                }
            }
        }

    }


}
