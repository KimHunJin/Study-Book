package programmers;

public class TargetNumber {

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        System.out.println(new TargetNumber().solution(numbers, target));
    }

    public int solution(int[] numbers, int target) {

        int length = numbers.length;

        int arrSize = makeArrSize(length);

        int[] startPosition = makeStartPosition(length);

        int[] sum = makeSum(arrSize, length, numbers, startPosition);

        int start = startPosition[length - 1];
        int end = startPosition[length];

        return find(sum, target, start, end);
    }

    private int makeArrSize(int length) {
        int arrSize = 0;
        for (int i = 1; i <= length; i++) {
            arrSize = arrSize + (int) Math.pow(2, i);
        }
        return arrSize;
    }

    private int[] makeStartPosition(int length) {
        int[] startPosition = new int[length + 1];
        startPosition[0] = 0;
        for (int i = 1; i < length + 1; i++) {
            startPosition[i] = startPosition[i - 1] + (int) (Math.pow(2, i));
        }

        return startPosition;
    }

    private int[] makeSum(int arrSize, int length, int[] numbers, int[] startPosition) {
        int[] sum = new int[arrSize];

        sum[0] = numbers[0];
        sum[1] = -1 * numbers[0];
        for (int i = 1; i < length; i++) {

            for (int j = startPosition[i]; j < startPosition[i + 1]; j++) {
                double before = Math.floor((float) j / 2);
                int beforeSum = (int) before - 1;
                int plusOrMinus = j % 2 == 0 ? 1 : -1;

                sum[j] = sum[beforeSum] + (plusOrMinus * numbers[i]);
            }
        }

        return sum;
    }

    private int find(int[] sum, int target, int start, int end) {
        int answer = 0;

        for (int i = start; i < end; i++) {
            if (sum[i] == target) {
                answer++;
            }
        }

        return answer;
    }
}
