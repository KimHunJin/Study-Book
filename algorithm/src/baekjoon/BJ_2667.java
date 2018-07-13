package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 백준 온라인 저지 2667
 *
 * <그림 1>과 같이 정사각형 모양의 지도가 있다.
 * 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
 * 철수는 이 지도를 가지고 연결된 집들의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
 * 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
 * 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
 * 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 *
 * 0110100          0110200
 * 0110101          0110202
 * 1110101          1110202
 * 0000111          0000222
 * 0100000          0300000
 * 0111110          0333330
 * 0111000          0333000
 * 그림<1>            <그림2>
 *
 * ex)
 * input            output
 * 7                3
 * 0110100          7
 * 0110101          8
 * 1110101          9
 * 0000111
 * 0100000
 * 0111110
 * 0111000
 *
 * solution
 * DFS or BFS
 *
 * hint
 * nothing
 */
public class BJ_2667 {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private int[][] map;
    private boolean[][] isVisit;
    private int n;

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        new BJ_2667().solve();
    }

    private void solve() {
        input();
        int count = 0;


        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !isVisit[i][j]) {
                    l.add(dfs(i, j));
                    count++;
                }
            }
        }
        Collections.sort(l);
        System.out.println(count);
        for (int i : l) {
            System.out.println(i);
        }
    }

    private int dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return 0;
        }

        if (map[x][y] <= 0) {
            return 0;
        }

        isVisit[x][y] = true;
        map[x][y] = -1;
        int c = 0;
        for (int i = 0; i < 4; i++) {
            c += dfs(x + dx[i], y + dy[i]);
        }
        return c + 1;
    }

    private void input() {
        n = iRead();

        map = new int[n][n];
        isVisit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
    }

    private int iRead() {
        return Integer.parseInt(readLine());
    }

    private String readLine() {

        String line = "";
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
