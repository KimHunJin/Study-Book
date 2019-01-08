package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2252 {

    public static void main(String[] args) throws IOException{

        new BJ_2252().solve();

    }

    private void solve() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        int[] calls = new int[n + 1];
        calls[0] = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String tmp[] = br.readLine().split(" ");
            int s = Integer.parseInt(tmp[0]);
            int l = Integer.parseInt(tmp[1]);

            map.get(s).add(l);
            calls[l]++;
        }

        List<Integer> result = new ArrayList<>();
        ArrayDeque<Integer> start = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (calls[i] == 0) {
                start.add(i);
            }
        }

        while (!start.isEmpty()) {
            int number = start.pop();
            result.add(number);
            for (int i = 0; i < map.get(number).size(); i++) {
                int getNum = map.get(number).get(i);
                calls[getNum]--;
                if(calls[getNum] == 0) {
                    start.add(getNum);
                }
            }
        }

        for(int r : result) {
            System.out.print(r+ " ");
        }
    }
}
