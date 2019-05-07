package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ_1076 {
    public static void main(String[] args) {
        new BJ_1076().solve();
    }

    private void solve() {
        String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < colors.length; i++) {
            map.put(colors[i], i);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            long sum = 0;
            String first = br.readLine();
            String second = br.readLine();
            String third = br.readLine();

            sum += map.get(first) * 10 + map.get(second);
            sum *= (long) (Math.pow(10, map.get(third)));

            System.out.println(sum);

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
