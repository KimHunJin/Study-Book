package line2019;

public class LineD {
    public static void main(String[] args) {
        int n = 7;
        int[] sits = {1,0,1,0,0,0,1};

        new LineD().solve(n, sits);
    }

    private void solve(int n, int[] sits) {
        int[] distanceMap = new int[n];

        int distance = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (sits[i] == 0) {
                distance++;
            } else {
                distance = 0;
            }
            distanceMap[i] = distance;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (sits[i] == 0) {
                distance++;
            } else {
                distance = 0;
            }
            distanceMap[i] = Math.min(distanceMap[i], distance);
            answer = Math.max(answer, distanceMap[i]);
        }

        System.out.println(answer);
    }
}
