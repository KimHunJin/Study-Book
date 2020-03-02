package line2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LineE {
    public static void main(String[] args) {
        new LineE().solve();
    }

    private void solve() {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tmp = br.readLine().split(" ");
            int n = Integer.parseInt(tmp[0], 10);
            int m = Integer.parseInt(tmp[1], 10);

            tmp = br.readLine().split(" ");


            int conyX = Integer.parseInt(tmp[0], 10);
            int conyY = Integer.parseInt(tmp[1], 10);

            if (conyX == 0 && conyY == 0) {
                System.out.println("fail");
                return;
            }

            if (conyX > n || conyY > m) {
                System.out.println("fail");
                return;
            }

            long[][] map = new long[conyX + 1][conyY + 1];
            int minTime = conyX + conyY;

            for (int i = 0; i < map.length; i++) {
                map[i][0] = 1;
            }

            for (int j = 0; j < map[0].length; j++) {
                map[0][j] = 1;
            }

            for (int i = 1; i < map.length; i++) {
                for (int j = 1; j < map[i].length; j++) {
                    map[i][j] = map[i][j - 1] + map[i - 1][j];
                }
            }

            System.out.println(minTime);
            System.out.println(map[conyX][conyY]);

        } catch (IOException ie) {
            ie.printStackTrace();
        }

    }
}
