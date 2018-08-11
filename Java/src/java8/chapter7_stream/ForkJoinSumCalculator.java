package java8.chapter7_stream;

import java.util.concurrent.RecursiveTask;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start;
    private final int end;

    public static final long THRESHOLD = 10_000;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    /**
     * RecursiveTask의 추상 메서드
     *
     * @return
     */
    @Override
    protected Long compute() {
        int length = end - start; // 태스크에 더할 배열의 길이
        if (length <= THRESHOLD) {
            return computeSequentially(); // 기준값과 같거나 작으면 순차적 결과 계산
        }
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2); // 배열의 1 ~ n/2까지 더하는 서브 태스트 생성
        leftTask.fork();

        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end); // 배열의 나머지 수를 더하는 서브태스크 생성
        Long rightResult = rightTask.compute(); // 두 번째 서브태스크 동기 실행
        Long leftResult = leftTask.join(); // 첫 번째 서브태스크의 결과를 읽거나 결과가 없다면 대기

        return leftResult + rightResult; // 두 서브태스크의 결과를 조합한 값이 이 태스크의 결과
    }

    /**
     * 더 분할할 수 없을 때 서브태스크의 결과를 계산하는 알고리즘
     * @return
     */
    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
