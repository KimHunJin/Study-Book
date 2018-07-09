package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BJ_2667 {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private int[][] map;
    private boolean[][] isVisit;
    private int n;

    private int[] dx = {0,0,1,-1};
    private int[] dy = {1,-1,0,0};

    public static void main(String[] args) {
        new BJ_2667().solve();
    }

    private void solve() {
        input();
        int count = 0;

        List<Integer> l = new ArrayList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(map[i][j] == 1 && !isVisit[i][j]) {
                    l.add(dfs(i,j));
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
        if(x < 0 || x >= n || y < 0 || y >= n) {
            return 0;
        }

        if(map[x][y] <= 0) {
            return 0;
        }

        isVisit[x][y] = true;
        map[x][y] = -1;
        int c = 0;
        for(int i=0;i<4;i++) {
            c += dfs(x+dx[i], y+dy[i]);
        }
        return c + 1;
    }

    private void input() {
        n = iRead();

        map = new int[n][n];
        isVisit = new boolean[n][n];

        for(int i=0;i<n;i++) {
            String s = readLine();
            for(int j=0;j<n;j++) {
                map[i][j] = s.charAt(j)-'0';
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
