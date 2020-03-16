package programmers;

import java.util.*;

public class FailureRate {

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 3, 3};

        int[] result = new FailureRate().solution(5, arr);
        for (int r : result) {
            System.out.println(r);
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int members = stages.length;
        int[] failureResult = new int[N];

        Stage[] stageArr = new Stage[N];

        for (int state : stages) {
            if (state > N) {
                continue;
            }
            failureResult[state - 1]++;
        }

        for (int i = 0; i < failureResult.length; i++) {
            if (members > 0) {
                int failCount = failureResult[i];
                stageArr[i] = new Stage(i + 1, (double)failCount / members);
                members -= failCount;
            } else {
                stageArr[i] = new Stage(i + 1, 0);
            }
        }

        Arrays.sort(stageArr, (o1, o2) -> Double.compare(o2.failureRate, o1.failureRate));

        for(int i=0; i<answer.length; i++) {
            answer[i] = stageArr[i].stage;
        }

        return answer;
    }


    class Stage {
        int stage;
        double failureRate;

        Stage(int stage, double failureRate) {
            this.stage = stage;
            this.failureRate = failureRate;
        }
    }
}
