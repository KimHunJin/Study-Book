package programmers;

public class SchoolRoad {
    public static void main(String[] args) {
        int m = 100;
        int n = 100;
        int[][] puddles = {
        };
        System.out.println(new SchoolRoad().solution(m, n, puddles));
    }

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int mod = 1000000007;

        int[] map = new int[m * n];
        map[0] = 1;

        for (int i = 0; i < puddles.length; i++) {
            int[] puddle = puddles[i];
            int puddleM = puddle[0] - 1;
            int puddleN = puddle[1] - 1;

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

            int left = 0;
            int top = 0;

            if (i % m != 0) {
                left = map[currentLeft];
            }

            if (i >= m) {
                top = map[currentTop];
            }

            map[i] = (left % mod) + (top % mod);
            map[i] = map[i] % mod;
        }

        for (int i = 0; i < map.length; i++) {
//            System.out.print(map[i] + " ");
            if (i % m == m-1) {
//                System.out.println();
            }

            if (map[i] > 1000000000) {
                System.out.println(i + " : " + map[i]);
            }
        }

        answer = map[map.length - 1];

        return answer;
    }
}
