package programmers;

import java.util.Arrays;

public class KIndexNumber {

    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };

        int[] result = new KIndexNumber().solution(array, commands);

        for(int r: result) {
            System.out.println(r);
        }
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++) {
            int[] command = commands[i];
            int startIndex = command[0] - 1;
            int lastIndex = command[1];
            int findIndex = command[2] -1;

            int[] sol = Arrays.copyOfRange(array, startIndex, lastIndex);
            Arrays.sort(sol);
            answer[i] = sol[findIndex];
        }

        return answer;
    }
}
