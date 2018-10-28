package Edaily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseGame {
    public static void main(String[] args) {
        new ReverseGame().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine(), 10);
            char[][] game = new char[n][n];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < n; j++) {
                    game[i][j] = s.charAt(j);
                }
            }
            loop(game, Integer.MAX_VALUE);
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private void loop(char[][] game, int min) {

        for (int i = 0; i < game.length; i++) {

            int w = 0;
            int b = 0;

            // 가로 체크
            for (int j = 0; j < game.length; j++) {
                if(game[i][j] == 'W') {
                    w++;
                } else {
                    b++;
                }
            }
            if(w >= b) {
                for(int j=0;j<game.length;j++) {
                    if(game[i][j] == 'W') {
                        game[i][j] = 'B';
                    }
                }
                i--;
            }
        }

        for(int i=0;i<game.length;i++) {
            int w = 0;
            int b = 0;
            for(int j=0;j<game.length;j++) {
                if(game[j][i] == 'W') {
                    w++;
                } else {
                    b++;
                }
            }
            if(w >= b) {
                for(int j=0;j<game.length;j++) {
                    if(game[j][i] == 'W') {
                        game[j][i] = 'B';
                    }
                }
                i--;
            }
        }

        int w = 0;

        for(int i=0;i<game.length;i++) {
            for(int j=0;j<game.length;j++) {
                if(game[i][j] == 'W') {
                    w++;
                }
            }
        }
        if(w < min) {
            loop(game, w);
        } else {
            System.out.println(min);
        }
    }

}
