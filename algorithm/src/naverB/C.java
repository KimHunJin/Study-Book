package naverB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class C {
    public static void main(String[] args) {
        new C().solve();
    }

    private void solve() {

        int[] cookTimes = {5, 30, 15, 30, 35, 20, 4};
        int[][] order = {{2, 4}, {2, 5}, {3, 4}, {3, 5}, {1, 6}, {4, 6}, {5, 6}, {6, 7}};
        int k = 6;


        int[] cookTimes2 = {5, 30, 15, 30, 35, 20, 4, 50, 40};
        int[][] order2 = {{2, 4}, {2, 5}, {3, 4}, {3, 5}, {1, 6}, {4, 6}, {5, 6}, {6, 7}, {8, 9}};
        int k2 = 9;

        int[] cookTimes3 = {5,3,2};
        int[][] order3 = {{1,2},{2,3},{1,3}};
        int k3 =3;

        int[] result = solution(cookTimes, order, k);
        System.out.println(result[0] + " : " + result[1]);

        int[] result2 = solution(cookTimes2, order2, k2);
        System.out.println(result2[0] + " : " + result2[1]);

        int[] result3 = solution(cookTimes3, order3, k3);
        System.out.println(result3[0] + " : " + result3[1]);
    }

    private int[] solution(int[] cookTimes, int[][] order, int k) {
        int[] answer = new int[2];

        int length = cookTimes.length + 1;
        // index 0을 제외하기 위해 1 추가
        List[] needs = new List[length];

        int[] counts = new int[length];
        int[] times = new int[length];
        int[] needsCount = new int[length];

        for (int i = 0; i < length; i++) {
            needs[i] = new ArrayList<Integer>();
        }

        for (int[] orders : order) {
            int number = orders[0];
            int need = orders[1];

            needs[number].add(need); // 현재 숫자 (number)가 사용되는 수(need)
            counts[need]++; // 수 (need)를 만들기 위해 필요한 갯수
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < length; i++) {
            if (counts[i] == 0) {
                q.add(i); // 큐에 선행이 필요하지 않은 것들을 추가함
                times[i] = cookTimes[i - 1];
                needsCount[i] = 1;
            }
        }

        for (int i = 1; i < length; i++) {
            int value = q.remove(); // 큐에서 값 하나 제거
            for (int j = 0; j < needs[value].size(); j++) {
                int v = (int) needs[value].get(j); // 선행되는 수가 사용되는 값
                counts[v]--; // 값의 필요 개수 하나 제거
                if (times[v] < times[value] + cookTimes[v - 1]) {
                    times[v] = times[value] + cookTimes[v - 1]; // 더 긴 시간으로 골라서 넣음
                }

                needsCount[v] += needsCount[value]; // 만들기 위해 필요한 갯수

                if (counts[v] == 0) {
                    q.add(v);
                }
            }
        }

        answer[0] = needsCount[k];
        answer[1] = times[k];

        return answer;
    }

    void print(List[] needs) {
        for (int i = 0; i < needs.length; i++) {
            System.out.println();
            System.out.print("index: " + i);
            System.out.print("need ");
            for (int j = 0; j < needs[i].size(); j++) {
                System.out.print(" " + needs[i].get(j));
            }
        }

    }
}
