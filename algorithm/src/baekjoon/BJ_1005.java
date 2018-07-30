package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [ input output example ]
 * 19
 * 3 2
 * 100 100 100
 * 1 2
 * 2 3
 * 1
 * 3 2
 * 100 100 100
 * 1 2
 * 2 3
 * 2
 * 11 10
 * 10 100 1 1 1 5 8 9 7 1000 10
 * 1 2
 * 2 3
 * 3 4
 * 4 5
 * 5 6
 * 6 7
 * 5 8
 * 8 9
 * 10 11
 * 11 3
 * 3
 * 11 10
 * 10 100 1 1 1 5 8 9 7 1000 10
 * 1 2
 * 2 3
 * 3 4
 * 4 5
 * 5 6
 * 6 7
 * 5 8
 * 8 9
 * 10 11
 * 11 3
 * 4
 * 11 10
 * 10 100 1 1 1 5 8 9 7 1000 10
 * 1 2
 * 2 3
 * 3 4
 * 4 5
 * 5 6
 * 6 7
 * 5 8
 * 8 9
 * 10 11
 * 11 3
 * 6
 * 4 4
 * 10 1 100 10
 * 1 2
 * 1 3
 * 2 4
 * 3 4
 * 4
 * 8 8
 * 10 20 1 5 8 7 1 43
 * 1 2
 * 1 3
 * 2 4
 * 2 5
 * 3 6
 * 5 7
 * 6 7
 * 7 8
 * 7
 * 10 11
 * 10 1 1 100 10 10 100 1 1 1
 * 1 2
 * 2 3
 * 3 6
 * 4 3
 * 4 7
 * 4 9
 * 5 4
 * 6 9
 * 7 8
 * 8 9
 * 10 7
 * 9
 * 5 4
 * 10 1 100 10 1000
 * 5 2
 * 1 3
 * 2 4
 * 3 4
 * 4
 * 7 6
 * 1 100 10 1000 10 1 1
 * 1 2
 * 2 3
 * 3 7
 * 4 5
 * 5 6
 * 6 7
 * 7
 * 7 6
 * 1 10 1 100 1 5 8
 * 1 2
 * 2 3
 * 4 5
 * 5 3
 * 3 6
 * 3 7
 * 3
 * 7 6
 * 1 10 1 100 1 5 8
 * 1 2
 * 2 3
 * 4 5
 * 5 3
 * 3 6
 * 3 7
 * 7
 * 5 3
 * 1 3 10 10 5
 * 1 4
 * 2 3
 * 3 5
 * 2
 * 5 3
 * 1 3 10 10 5
 * 1 4
 * 2 3
 * 3 5
 * 3
 * 5 3
 * 1 3 10 10 5
 * 1 4
 * 2 3
 * 3 5
 * 5
 * 5 3
 * 1 3 10 10 5
 * 1 4
 * 2 3
 * 3 5
 * 4
 * 5 3
 * 1 3 10 10 5
 * 1 4
 * 2 3
 * 3 5
 * 1
 * 2 1
 * 10 5
 * 2 1
 * 2
 * 2 1
 * 10 5
 * 2 1
 * 1
 *
 *
 * [[ ANSWER ]]
 * 100
 * 200
 * 1011
 * 1012
 * 1018
 * 120
 * 39
 * 212
 * 1011
 * 1012
 * 102
 * 110
 * 3
 * 13
 * 18
 * 11
 * 1
 * 5
 * 15
 */
public class BJ_1005 {
    public static void main(String[] args) {
        new BJ_1005().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = iRead(br);
            for (int i = 0; i < n; i++) {
                unit_solve(br);
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private void unit_solve(BufferedReader br) {
        String[] dmp = input(br).split(" ");
        int n = convertInt(dmp[0]);
        int k = convertInt(dmp[1]);
        int[] time = new int[n + 1];
        int[][] map = new int[n + 1][n + 1];
        int[] needs = new int[n + 1];

        dmp = input(br).split(" ");
        for (int i = 0; i < n; i++) {
            time[i + 1] = convertInt(dmp[i]);
        }

        for (int i = 0; i < k; i++) {
            dmp = input(br).split(" ");
            int start = convertInt(dmp[0]);
            int destination = convertInt(dmp[1]);

            map[start][destination] = 1;
            needs[destination]++;
        }

        int find = iRead(br);

        int[] result = topologicalSort(map, time, needs);
        System.out.println(result[find]);
    }

    private int[] topologicalSort(int[][] map, int[] time, int[] needs) {
        Queue<Integer> q = new LinkedList<>();

        int size = needs.length;
        int[] timeSet = new int[size];

        for (int i = 1; i < size; i++) {
            if (needs[i] == 0) {
                timeSet[i] = time[i];
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int n = q.poll();
            for (int i = 1; i < size; i++) {
                if (map[n][i] == 1) {
                    timeSet[i] = Math.max(timeSet[i], timeSet[n] + time[i]);

                    needs[i]--;

                    if (needs[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }
        return timeSet;
    }

    private int convertInt(String s) {
        return Integer.parseInt(s);
    }

    private int iRead(BufferedReader br) {
        return Integer.parseInt(input(br));
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
