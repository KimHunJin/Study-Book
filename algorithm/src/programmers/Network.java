package programmers;

import java.util.ArrayList;
import java.util.List;

public class Network {

    List<Integer> visitList = new ArrayList();
    int[][] computers;
    int result = 0;

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };

        System.out.println(new Network().solution(n, computers));
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.computers = computers;

        for (int i=0; i<n; i++) {
            network(i, true);
        }

        answer = result;
        return answer;
    }

    void network(int number, boolean isFirst) {
        int[] computer = this.computers[number];
        if (visitList.contains(number)) {
            return;
        }

        if (isFirst) {
            result++;
        }

        visitList.add(number);

        for (int i=0; i<computer.length; i++) {
            if (i == number) {
                continue;
            }
            if (visitList.contains(i)) {
                continue;
            }

            if (computer[i] == 1) {
                network(i, false);
            }
        }
    }

}
