package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1067 {
    public static void main(String[] args) {
        new BJ_1067().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine(), 10);

            int x[] = new int[n];
            int y[] = new int[n];

            String[] tmp = br.readLine().split(" ");
            String[] tmp2 = br.readLine().split(" ");

            int xMaxIndex = 0;
            int xMax = 0;
            int yMaxIndex = 0;
            int yMax = 0;

            for (int i = 0; i < n; i++) {
                x[i] = Integer.parseInt(tmp[i], 10);
                y[i] = Integer.parseInt(tmp2[i], 10);

                if (x[i] > xMax) {
                    xMax = x[i];
                    xMaxIndex = i;
                }

                if (y[i] > yMax) {
                    yMax = y[i];
                    yMaxIndex = i;
                }
            }

            int index = Math.abs(xMaxIndex - yMaxIndex);

            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (x[(i+index)%n] * y[i]);
            }

            System.out.println(sum);


        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
