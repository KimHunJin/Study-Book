package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_14501 {
    public static void main(String[] args) {
        new BJ_14501().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine(), 10);

            Consulting[] con = new Consulting[n];
            for (int i = 0; i < n; i++) {
                String tmp[] = br.readLine().split(" ");
                int t = Integer.parseInt(tmp[0], 10);
                int p = Integer.parseInt(tmp[1], 10);
                con[i] = new Consulting(t, p);
            }

            solution(con);

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private void solution(Consulting[] con) {
        int[][] consulting = new int[con.length + 1][con.length + 1];
        for (int i = 1; i <= con.length; i++) {
            Consulting c = con[i - 1];
            int t = c.t;
            int p = c.p;

            int size = i + t;
            if(size > con.length+1) {
                size = con.length+1;
                p = -1;
            }
            for (int j = i; j < size; j++) {
                consulting[i][j] = p;
            }
        }

        for(int n[] : consulting) {
            for (int m: n) {
                System.out.print(m + "\t");
            }
            System.out.println();
        }
    }

    class Consulting {
        int t;
        int p;

        Consulting(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }
}
