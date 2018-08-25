package baekjoon.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 위상정렬 문제
 * <p>
 * [ solution ] // 로직
 * 필요 조건이 없는 것 부터 queue에 담는다.
 * 큐에 담겨진 수를 제거했을 때 필요한 조건이 없는 것을 queue에 담는다.
 * 큐에 담겨진 수를 제거하기 전 큐에 들어있는 수들의 weight가 가장 큰 수를 더한다.
 * 큐에 찾고자 하는 수가 들어와 poll되기 전까지 반복한다.
 *
 * <p>
 * 1 -> 2
 * 1 -> 3
 * 2 -> 4
 * 3 -> 4
 * <p>
 * queue(1)
 * -> poll(1)
 * -> time + time(1)
 * <p>
 * queue(2,3)
 * -> poll(2) poll(3)
 * -> time + Max(time(2), time(3))
 * <p>
 * queue(4)
 * -> poll(4)
 * -> time + time(4)
 *
 * [ 문제 발생 ]
 * 1. 같은 큐에 들어갈 때 같은 시간이 걸린다고 계산하여 무조건적인 덧셈 발생
 *
 */
public class BJ_1005_Error {
    public static void main(String[] args) {
        new BJ_1005_Error().solve();
    }

    private class ACM {
        private int number;
        private int needsCount; // 이 건물을 짓기 위해 필요한 건물의 수
        private int weight; // 이 건물을 짓는데 필요한 비용
        private List<Integer> available = new ArrayList<>(); // 이 건물이 필요한 건물
        private List<Integer> needs = new ArrayList<>(); // 이 건물을 짓기 위해 필요한 견물

        public int getNeedsCount() {
            return needsCount;
        }

        public int getWeight() {
            return weight;
        }

        public List<Integer> getAvailable() {
            return available;
        }

        public List<Integer> getNeeds() {
            return needs;
        }

        ACM(int number, int weight) {
            this.weight = weight;
            this.number = number;
        }
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
        System.out.println("----------");
        ACM[] acms = init(br);

        int findNumber = iRead(br);

        int time = 0;

        while (true) {
            List<ACM> list = Arrays.stream(acms)
                    .filter(c -> c.getNeedsCount() == 0)
                    .sorted(Comparator.comparing(ACM::getWeight).reversed())
                    .collect(Collectors.toList());
            if(list.contains(acms[findNumber])) {
                time += acms[findNumber].weight;
                break;
            }

            time += list.get(0).weight;
            for(ACM a : list) {
                int number = a.number;
                acms[number].needsCount = -1;
                for(int n : a.available) {
                    acms[n].needsCount--;
                    for(int i=0;i<acms[n].needs.size();i++) {
                        if(acms[n].needs.get(i).equals(number)) {
                            acms[n].needs.remove(i);
                        }
                    }
                }
            }
        }
        System.out.println(time);
    }

    private ACM[] init(BufferedReader br) {
        String[] dmp = input(br).split(" ");
        int n = convertInt(dmp[0]);
        int k = convertInt(dmp[1]);

        ACM[] acms = new ACM[n + 1];

        dmp = input(br).split(" ");

        acms[0] = new ACM(0, 0);
        acms[0].needsCount = -1;
        for (int i = 0; i < n; i++) {
            acms[i + 1] = new ACM(i + 1, convertInt(dmp[i]));
        }

        for (int i = 0; i < k; i++) {
            dmp = input(br).split(" ");
            int start = convertInt(dmp[0]);
            int destination = convertInt(dmp[1]);

            acms[start].available.add(destination);
            acms[destination].needsCount++;
            acms[destination].needs.add(start);
        }
        return acms;
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
