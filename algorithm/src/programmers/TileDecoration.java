package programmers;

public class TileDecoration {
    public static void main(String[] args) {
        System.out.println(new TileDecoration().solution(80));
    }

    public long solution(int N) {
        long answer = 0;

        if (N == 1) {
            return 4;
        }

        if (N == 2) {
            return 6;
        }

        long[] arr = new long[N+1];
        arr[0] = 1;
        arr[1] = 1;

        for (int i=2; i<N; i++) {
            arr[i] = arr[i-2] + arr[i-1];
            answer = ((arr[i] + arr[i-1]) + (arr[i-1] + arr[i-2])) * 2;
        }

        return answer;
    }
}
