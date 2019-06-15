package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1476 {
    public static void main(String[] args) {
        new BJ_1476().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[] tmp = br.readLine().split(" ");

            int first = Integer.parseInt(tmp[0], 10);
            int second = Integer.parseInt(tmp[1], 10);
            int third = Integer.parseInt(tmp[2], 10);

            int count = 0;
            while (true) {
                int k = 28 * count + second;

                int checkThird = k % 19;
                if(checkThird == 0) {
                    checkThird = 19;
                }
                if (checkThird == third) {
                    int checkFirst = k % 15;
                    if(checkFirst == 0) {
                        checkFirst = 15;
                    }
                    if (checkFirst == first) {
                        System.out.println(k);
                        break;
                    }
                }
                count++;
            }

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
