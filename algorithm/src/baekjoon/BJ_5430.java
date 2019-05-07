package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_5430 {
    public static void main(String[] args) {
        new BJ_5430().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine(), 10);
            while (T-- >= 0) {
                String fun = br.readLine();
                int n = Integer.parseInt(br.readLine(), 10);
                String tmp = br.readLine();
                tmp = tmp.substring(1, tmp.length() - 1);
                String[] arr = tmp.split(",");

                solution(fun, n, arr);
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }


    private void solution(String fun, int n, String[] arr) {
        for (int i = 0; i < fun.length(); i++) {
            char c = fun.charAt(i);
            switch (c) {

            }
        }
    }
}
