package baekjoon;

import java.util.*;

public class BJ_1753 {
    public static void main(String[] args) {
        new BJ_1753().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int V = Integer.parseInt(s[0], 10);
        int E = Integer.parseInt(s[1], 10);

        Map<Integer, List<Weight>> map = new HashMap<>();
        int start = Integer.parseInt(sc.nextLine(), 10);

        int[] result = new int[V + 1];

        result[start] = 0;

        for(int i = 1; i<=V;i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            s = sc.nextLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);

            Weight weight = new Weight(v, w);
            map.get(u).add(weight);
        }

        Queue<Integer> q =  new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {
            int cs = q.poll();
            for (int i = 0; i < map.get(cs).size(); i++) {
                int des = map.get(cs).get(i).destination;
                int wei = map.get(cs).get(i).weight;
                if (result[des] != 0 && result[des] > result[cs] + wei) {
                    result[des] = result[cs] + wei;
                    q.add(des);
                } else if(result[des] == 0 && des != start) {
                    result[des] = result[cs] + wei;
                    q.add(des);
                }
            }
        }

        for (int i = 1; i < result.length; i++) {
            if(i!=start && result[i] == 0) {
                System.out.println("INF");
            } else {
                System.out.println(result[i]);
            }
        }

    }

    class Weight {
        int destination;
        int weight;

        public Weight(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}
