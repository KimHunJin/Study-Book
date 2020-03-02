package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1188 {
    public static void main(String[] args) {
        new BJ_1188().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tmp = br.readLine().split(" ");
            int bread = Integer.parseInt(tmp[0], 10);
            int person = Integer.parseInt(tmp[1], 10);

            System.out.println(person - cut(bread, person));

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private int cut(int bread, int person) {
        if (person == 0) return bread;

        return cut(person, bread % person);
    }
}
