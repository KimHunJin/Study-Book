package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        int[] numbers = {0, 100, 10};

        System.out.println(new LargestNumber().solution(numbers));
    }

    public String solution(int[] numbers) {
        String answer = "";

        String[] sArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            sArr[i] = numbers[i] + "";
        }

        Arrays.sort(sArr, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        for (int i = sArr.length - 1; i >= 0; i--) {
            answer += sArr[i];
        }

        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer;
    }
}
