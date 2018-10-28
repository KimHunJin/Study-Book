package line.newcomer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws IOException {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int n = Integer.parseInt(br.readLine());
            int curX = 0;
            int curY = 1;
            String[][] s = new String[n][n];
            for (int i = 0; i < n; i++) {
                // @todo Write your code here.
                s[i] = br.readLine().split(" ");
            }

            int F = 0;
            int R = 1;
            int L = 2;
            int B = 3;


            int[][] dis = new int[4][4];

            dis[F][F] = F;
            dis[F][R] = R;
            dis[F][L] = L;
            dis[F][B] = B;

            dis[R][F] = R;
            dis[R][R] = B;
            dis[R][L] = F;
            dis[R][B] = L;

            dis[L][F] = L;
            dis[L][R] = F;
            dis[L][L] = B;
            dis[L][B] = R;

            dis[B][F] = B;
            dis[B][R] = L;
            dis[B][L] = R;
            dis[B][B] = F;


            int x = 0;
            int y = 0;

            // CardShuffle, R, L, B
            int[] realX = {1, 0, 0, -1};
            int[] realY = {0, 1, -1, 0};

            int before = F;

            boolean[][] isVisit = new boolean[n][n];
            while(true) {
                if(isVisit[x][y]) {
                    break;
                }
                isVisit[x][y] = true;
                char c = s[x][y].charAt(0);
                char m = s[x][y].charAt(1);
                int current = 0;
                switch (c) {
                    case 'F' : current = 0; break;
                    case 'B' : current = 3; break;
                    case 'L' : current = 2; break;
                    case 'R' : current = 1; break;
                }

                int moveX = dis[before][current];
                int moveY = dis[before][current];

                x += (m * realX[moveX]);
                y += (m * realY[moveY]);

                before = current;

            }
            System.out.println(x + " " + y);
            // @todo Write your code here.
        }
    }
}
