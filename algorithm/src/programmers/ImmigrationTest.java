package programmers;

class ImmigrationTest {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        long minTime = 0;
        long maxTime = 0;
        long mid = 0;

        for (int time: times) {
            if (maxTime < time) {
                maxTime = time;
            }
        }

        maxTime = maxTime * n;

        while (minTime <= maxTime) {
            mid = (maxTime + minTime) / 2;
            long count = 0;

            for (int time: times) {
                count = count + (mid / time);
            }

            if (count < n) {
                minTime = mid + 1;
            } else {
                if (mid < answer) {
                    answer = mid;
                }
                maxTime = mid - 1;
            }
        }

        return answer;
    }
}
