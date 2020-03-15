package programmers;

class MaxTriangle {

    public static void main(String[] args) {

    }

    public int solution(int[][] triangle) {
        int answer = 0;

        int height = triangle.length;
        int[] maxArr = new int[triangle[height - 1].length];
        maxArr[0] = triangle[0][0];
        for (int i = 1; i < height; i++) {
            int[] prev = triangle[i-1];
            int[] floor = triangle[i];
            for (int j = floor.length - 1; j >= 0; j--) {
                if (j == 0) {
                    maxArr[j] = maxArr[j] + floor[j];
                } else {
                    int origin = maxArr[j];
                    int prevA = Math.max(origin, maxArr[j-1] + floor[j]);
                    int prevB = Math.max(origin, maxArr[j] + floor[j]);

                    maxArr[j] = Math.max(prevA, prevB);
                }
                if (answer < maxArr[j]) {
                    answer = maxArr[j];
                }
            }
        }

        return answer;
    }
}
