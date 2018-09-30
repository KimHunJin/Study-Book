package kakao.kakao_2018;

public class D {
    public static void main(String[] args) {
        int[] time = {3, 1, 2};
        int k = 5;

        D d = new D();

//        int result = d.solution(time, k);
        //       System.out.println(result);

        time = new int[]{6, 3, 11, 3, 5, 7};
        int result2 = d.solution(time, 19);
        System.out.println(result2);

        time = new int[]{4, 3, 3};
        int result3 = d.solution(time, 9);
        System.out.println(result3);

        time = new int[]{1, 1, 2};
        int result4 = d.solution(time, 3);
        System.out.println(result4);
    }

    // 예외 케이스
    private int check(long sum, long k, int length, int[] food_times) {
        if (sum <= k) {
            return -1;
        }

        if (length > k) {
            return (int) k + 1;
        }

        if (length == k) {
            int count = 0;
            while (food_times[count % length] == 0) {
                count++;
            }
            return (count + 1);
        }

        return 0;
    }


    public int solution(int[] food_times, long k) {

        int length = food_times.length;

        // 몫과 나머지 구하기
        long iMoc = k / length;
        long iMod = k % length;

        long total = 0;

        for (int i = 0; i < length; i++) {
            total += food_times[i];
            if (food_times[i] - iMoc >= 0) {
                food_times[i] = (int) (food_times[i] - iMoc);
            } else {
                long tmp = iMoc - food_times[i];
                food_times[i] = 0;
                iMod = iMod + tmp;
            }
        }

        int value = check(total, k, length, food_times);

        if (value != 0) {
            return value;
        }

        int answer = 0;
        while (iMod > 0) {
            if (food_times[answer % length] > 0) {
                food_times[answer % length]--;
                iMod--;
                answer++;
            } else {
                answer++;
            }
        }

        answer = answer % length;

        while (food_times[answer] == 0) {
            answer = (answer + 1) % length;
        }

        answer = answer + 1;

        return answer;

    }
}
