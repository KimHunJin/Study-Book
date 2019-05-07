package line.threedayintern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Rope {
    public static void main(String[] args) {
        new Rope().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine(), 10);
            int[] building = new int[n];
            for (int i = 0; i < n; i++) {
                building[i] = Integer.parseInt(br.readLine(), 10);
            }

            int max = 0;
            int currentHeight = 0;
            int startIndex = 0;

            for (int i = 0; i < building.length; i++) {
                if(currentHeight <= building[i]) {
                    int length = i - startIndex;
                    if(max < length) {
                        max = length;
                    }
                    currentHeight = building[i];
                    startIndex = i;
                }
            }

            System.out.println(max);

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
