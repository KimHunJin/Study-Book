package programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12914?language=java
 * <p>
 * 프로그래머스 멀리 뛰기
 */
public class LongJump {
    public static void main(String[] args) {
        new LongJump().solve();
    }

    private void solve() {
        int n = 3;
        System.out.println(solution(n));
    }

    public long solution(int n) {
        long answer = 0;

        long[] jump = new long[n + 1];
        jump[0] = 1;
        jump[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            jump[i] = jump[i - 1] + jump[i - 2];
            jump[i] = jump[i] % 1234567;
        }

        answer = jump[n];

        return answer;
    }
}
