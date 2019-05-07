package AssistantAlpha;

public class A {
    public static void main(String[] args) {

        new A().solve();

    }

    private void solve() {
        int[][] numbers = new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4},
                {1, 2, 7, 6, 4}
        };


        for (int[] num : numbers) {
            System.out.println(makeNumber(num));
        }

    }

    private int makeNumber(int[] nums) {
        int size = nums.length;
        int first = size - 3;
        int second = size - 2;
        int third = size - 1;

        int count = 0;
        for (int i = 0; i <= first; i++) {
            for (int j = i + 1; j <= second; j++) {
                for (int k = j + 1; k <= third; k++) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (findPrime(sum)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean findPrime(int n) {
        if (n == 1) {
            return false;
        }
        boolean isPrime = true;
        for (int j = 2; j * j <= n; j++) {
            if (n % j == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
