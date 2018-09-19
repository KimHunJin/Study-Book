package kakao.kakao_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Kakao_2018_Music_Recommendation {
    public static void main(String[] args) throws IOException {
        new Kakao_2018_Music_Recommendation().solve();
    }

    private int N, Q;
    private long J;

    private ArrayList<Integer>[] graph;
    private boolean[] isVisit;
    private int[] ordering;
    private Pair[] affects;

    private int[] root;
    private long[] score;
    private long[] total;

    private int index = 1;

    class Pair {
        int min;
        int max;

        Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    private long get(int idx) {
        long sum = 0;
        while (idx > 0) {
            sum += total[idx];
            idx -= (idx & -idx);
        }

        return sum;
    }

    private void update(int idx, long val) {
        while (idx <= N) {
            total[idx] += val;
            idx += (idx & -idx);
        }
    }

    private void rangeUpdate(int q) {
        int node = root[q];
        long length = affects[node].max - affects[node].min + 1;
        long cal = score[q] / length;

        update(affects[node].min, cal);
        update(affects[node].max + 1, -cal);
    }

    private void dfs(int u) {
        int l, r;
        l = index;
        isVisit[u] = true;
        ordering[u] = index;

        for (int n : graph[u]) {
            if (!isVisit[n]) {
                ++index;
                dfs(n);
            }
        }

        r = index;
        affects[u] = new Pair(l, r);
    }

    private void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0], 10);
        Q = Integer.parseInt(tmp[1], 10);
        J = Integer.parseInt(tmp[2], 10);

        ArrayList<Integer>[] album = new ArrayList[N + 1];
        graph = new ArrayList[N + 1];
        int[] singer = new int[N + 1];
        isVisit = new boolean[N + 1];
        ordering = new int[N + 1];
        affects = new Pair[N + 1];
        root = new int[N + 1];
        score = new long[N + 1];
        total = new long[N + 1];
        int[] lo = new int[N + 1];
        int[] hi = new int[N + 1];
        ArrayList<Integer>[] predicted = new ArrayList[N + 1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
            album[i] = new ArrayList<>();
            predicted[i] = new ArrayList<>();
        }

        tmp = br.readLine().split(" ");
        for (int i = 2; i <= N; i++) {
            int tp = Integer.parseInt(tmp[i - 2], 10);
            graph[tp].add(i);
        }

        tmp = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            singer[i] = Integer.parseInt(tmp[i - 1], 10);
            album[singer[i]].add(i);
        }

        dfs(1);

        ArrayList<Pair> T = new ArrayList<>();
        T.add(new Pair(0, 0));

        for (int i = 1; i <= Q; i++) {
            tmp = br.readLine().split(" ");
            int t = Integer.parseInt(tmp[0], 10);
            root[i] = Integer.parseInt(tmp[1], 10);
            score[i] = Integer.parseInt(tmp[2], 10);

            T.add(new Pair(t, i));
        }

        Comparator<Pair> comparator = (o1, o2) -> {
            if (o1.min > o2.min) {
                return 1;
            } else if (o1.min < o2.min) {
                return -1;
            } else {
                return Integer.compare(o2.max, o1.max);
            }
        };

        T.sort(comparator);

        for (int i = 1; i <= N; i++) {
            lo[i] = (album[i].isEmpty() ? Q + 1 : 1);
            hi[i] = Q + 1;
        }

        boolean changed = true;

        while (changed) {
            Arrays.fill(total, 0);

            for (int i = 1; i <= N; i++) {
                if (lo[i] != hi[i]) {
                    predicted[(lo[i] + hi[i]) >> 1].add(i);
                }
            }

            changed = false;

            for (int q = 1; q <= Q; q++) {
                int index = T.get(q).max;
                rangeUpdate(index);

                while (predicted[q].size() > 0) {
                    changed = true;
                    int singerId = predicted[q].get(predicted[q].size() - 1);
                    predicted[q].remove(predicted[q].size() - 1);

                    long sum = 0;
                    long goalScore = J * album[singerId].size();

                    for (int song : album[singerId]) {
                        sum += get(ordering[song]);
                        if (sum >= goalScore) break;
                    }

                    if (sum > goalScore) {
                        hi[singerId] = q;
                    } else {
                        lo[singerId] = q + 1;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (lo[singer[i]] <= Q) {
                System.out.println(T.get(lo[singer[i]]).min);
            } else {
                System.out.println(-1);
            }
        }
    }

}
