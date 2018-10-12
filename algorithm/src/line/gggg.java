package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gggg {
    static int N;
    static int M;

    static boolean[][] isCheck;

    static int[][] map;

    static int[][] mapC;

    public static void main(String[] args) throws IOException {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            M = Integer.parseInt(tokenizer.nextToken());

            map = new int[N][M];
            mapC = new int[N][M];

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < s.length(); j++) {
                    map[i][j] = s.charAt(j);
                }
            }

            isCheck = new boolean[N][M];

            int startX = 0;
            int startY = 0;

            find(startX, startY, 0, true);
            System.out.println(mapC[N - 1][M - 1]);
        }
    }


    static void find(int x, int y, int count, boolean isUsed) {
        if (mapC[x][y] > count || mapC[x][y] == 0) {
            mapC[x][y] = count;
        }

        int[] moveX = {0, 0, 1, -1};
        int[] moveY = {1, -1, 0, 0};

        isCheck[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int mx = moveX[i] + x;
            int my = moveY[i] + y;
            if (mx >= N || my >= M || mx < 0 || my < 0) {
                return;
            }
            if (map[mx][my] == 'R' && !isCheck[mx][my]) {
                find(x + moveX[i], y + moveY[i], count + 1, isUsed);
            }
            if (map[mx][my] == 'M' && isUsed && !isCheck[mx][my]) {
                isUsed = false;
                find(x + moveX[i], y + moveY[i], count + 1, isUsed);
            }
        }

        if (x == N - 1 && y == M - 1) {
            return;
        }

    }
}
