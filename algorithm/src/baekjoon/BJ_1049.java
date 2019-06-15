package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1049 {
    public static void main(String[] args) {
        new BJ_1049().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String dump[] = br.readLine().split(" ");

            int n = Integer.parseInt(dump[0], 10);
            int m = Integer.parseInt(dump[1], 10);

            int minPackCost = Integer.MAX_VALUE;
            int minEachCost = Integer.MAX_VALUE;

            for (int i = 0; i < m; i++) {
                String tmp[] = br.readLine().split(" ");
                int pack = Integer.parseInt(tmp[0]);
                int each = Integer.parseInt(tmp[1]);

                minPackCost = Math.min(minPackCost, pack);
                minEachCost = Math.min(minEachCost, each);

            }

            int packCount = n / 6;
            int eachCount = n % 6;

            int maxPackCount = packCount + 1;
            int maxEachCount = n;


            int packEach = (packCount * minPackCost) + (eachCount * minEachCost);
            int minPack = maxPackCount * minPackCost;
            int minEach = maxEachCount * minEachCost;

            int result = Math.min(packEach, Math.min(minEach, minPack));

            System.out.println(result);

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
