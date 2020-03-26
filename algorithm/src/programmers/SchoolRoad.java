package programmers;

public class SchoolRoad {
    public static void main(String[] args) {
        int m = 10;
        int n = 20;
        int[][] puddles = {
                {1, 6},
                {2, 2},
                {2, 5},
                {3, 8},
                {5, 6},
                {9, 9},
                {10, 9},
        };
        System.out.println(new SchoolRoad().solution(m, n, puddles));
    }

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int mod = 1000000007;

        long[] map = new long[m * n];
        map[0] = 1;

        for (int i = 0; i < puddles.length; i++) {
            int[] puddle = puddles[i];
            int puddleM = puddle[1] - 1;
            int puddleN = puddle[0] - 1;

            int puddlePosition = puddleM * m + puddleN;
            map[puddlePosition] = -1;
        }

        for (int i = 1; i < map.length; i++) {

            if (map[i] == -1) {
                map[i] = 0;
                continue;
            }

            int currentLeft = i - 1;
            int currentTop = i - m;

            long left = 0;
            long top = 0;

            if (i % m != 0) {
                left = map[currentLeft];
            }

            if (i >= m) {
                top = map[currentTop];
            }

            map[i] = left + top;
            map[i] = map[i] % mod;
        }

        answer = (int) (map[map.length - 1] % mod);

        return answer;
    }
}
