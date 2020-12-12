package programmers;

import java.util.ArrayList;
import java.util.Arrays;

class Rank {
    public static void main(String[] args) {
        new Rank().solve();
    }

    private void solve() {
        int n = 5;
        int[][] results = {
                {4, 3},
                {4, 2},
                {3, 2},
                {1, 2},
                {2, 5}
        };

        System.out.println(solution(n, results));
    }

    int[] upward;
    int[] downward;

    boolean[] isVisit;
    ArrayList<Integer>[] connectionPool;

    public int solution(int n, int[][] results) {
        int answer = 0;

        upward = new int[n + 1];
        downward = new int[n + 1];
        isVisit = new boolean[n + 1];
        connectionPool = makeConnectionPool(n, results);

        for (int i = 1; i <= n; i++) {
            connection(i);
            initVisit();
        }

        for (int i = 1; i <= n; i++) {
            if (upward[i] + downward[i] == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    private void initVisit() {
        Arrays.fill(isVisit, false);
    }

    private void connection(int startNumber) {

        ArrayList<Integer> connection = connectionPool[startNumber];

        for (int nextNumber : connection) {
            connection(startNumber, nextNumber);
        }
    }

    private void connection(int startNumber, int next) {
        if (isVisit[next]) {
            return;
        }

        downward[startNumber]++;
        upward[next]++;
        isVisit[next] = true;

        ArrayList<Integer> connection = connectionPool[next];
        for (int nextNumber : connection) {
            connection(startNumber, nextNumber);
        }
    }

    private ArrayList<Integer>[] makeConnectionPool(int n, int[][] results) {
        ArrayList<Integer>[] arr = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int[] result : results) {
            int win = result[0];
            int looser = result[1];

            arr[win].add(looser);
        }

        return arr;
    }

}
