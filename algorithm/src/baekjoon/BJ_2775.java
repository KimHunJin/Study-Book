package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2775 {
    public static void main(String[] args) {
        new BJ_2775().solve();
    }

    private void solve() {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = convertInt(input(br));
            for(int i=0;i<n;i++) {

                unitTest(br);
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private void unitTest(BufferedReader br) {
        int n = convertInt(input(br));
        int k = convertInt(input(br));

        int[][] map = new int[n+1][k];
        for(int i=0;i<k;i++) {
            map[0][i] = i+1;
        }

        for(int i=1;i<=n;i++) {
            for(int j=0;j<k;j++) {
                int sum = 0;
                for(int t=0;t<=j;t++) {
                    sum += map[i-1][t];
                }
                map[i][j] = sum;
            }
        }

        System.out.println(map[n][k-1]);
    }

    private int convertInt(String s) {
        return Integer.parseInt(s);
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
