package programmers;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {

        int[] citations = {0, 1, 3, 4, 5};
        System.out.println(new HIndex().solution(citations));

    }

    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        int size = citations.length;

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= size - i) {
                answer = size - i;
                break;
            }
        }

        return answer;
    }
}
