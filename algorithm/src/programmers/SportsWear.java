package programmers;

import java.util.Arrays;

class SportsWear {
    public static void main(String[] args) {
        new SportsWear().solve();
    }

    private void solve() {
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};

        System.out.println(solution(n, lost, reserve));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        // 모두 가지고 있는 상태로 초기화
        int[] studyAbleStudent = new int[n + 1];
        Arrays.fill(studyAbleStudent, 1);
        studyAbleStudent[0] = 0; // 0 번째 인덱스는 존재하지 않기 때문에 0으로 변경

        // 잃어 버린 학생은 감소 ( 1 -> 0 )
        for (int value : lost) {
            studyAbleStudent[value]--;
        }

        // 보유 중인 학생은 증가 ( 1 -> 2)
        for (int reservableStudent : reserve) {
            studyAbleStudent[reservableStudent]++;
        }

        for (int i = 1; i <= n; i++) {
            boolean existSportsWear = studyAbleStudent[i] >= 1;
            // 옷이 없는 학생이면
            if (!existSportsWear) {
                // 이전 학생한테서 빌리기 시작
                if (checkBorrow(i - 1, studyAbleStudent)) {
                    studyAbleStudent[i]++;
                    studyAbleStudent[i - 1]--;
                    continue;
                }

                // 다음 학생한테 빌리기 시작
                if (checkBorrow(i + 1, studyAbleStudent)) {
                    studyAbleStudent[i]++;
                    studyAbleStudent[i + 1]--;
                }
            }
        }

        // 한 개 이상 들고 있는 학생만 카운팅
        for (int value: studyAbleStudent) {
            if (value >= 1) {
                answer++;
            }
        }

        return answer;
    }

    boolean checkBorrow(int index, int[] studyAbleStudent) {
        if (index < 0) {
            return false;
        }
        if (index >= studyAbleStudent.length) {
            return false;
        }

        return studyAbleStudent[index] == 2;
    }
}
