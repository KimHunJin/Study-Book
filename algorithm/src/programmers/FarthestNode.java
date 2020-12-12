package programmers;

import java.util.ArrayList;
import java.util.Arrays;

class FarthestNode {
    public static void main(String[] args) {
        new FarthestNode().solve();
    }

    private void solve() {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(solution(n, edge));
    }

    private ArrayList<Integer>[] graph;
    private int[] dist;
    private int max = 0;

    public int solution(int n, int[][] edge) {
        int answer = 0;

        graph = new ArrayList[n + 1];
        dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        dist[1] = 0;

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] node : edge) {
            int start = node[0];
            int end = node[1];

            graph[start].add(end);
            graph[end].add(start);
        }

        for (int i = 0; i < graph[1].size(); i++) {
            int nextNode = graph[1].get(i);
            find(nextNode, 1);
        }

        for (int dis: dist) {
            if (max == dis) {
                answer++;
            }
            if (dis > max) {
                max = dis;
                answer = 1;
            }
        }

        return answer;
    }

    private void find(int next, int dis) {
        if (dist[next] > dis) {
            dist[next] = dis;
        } else {
            return;
        }

        for (int i = 0; i < graph[next].size(); i++) {
            int nextNode = graph[next].get(i);
            find(nextNode, dis + 1);
        }
    }
}
