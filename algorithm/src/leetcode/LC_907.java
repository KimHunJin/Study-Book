package leetcode;

public class LC_907 {

    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4};
        System.out.println(new LC_907().sumSubarrayMins(A));
    }

    public int sumSubarrayMins(int[] A) {
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            int current = A[i];
            int count = 1;
            for (int j = i + 1; j < A.length; j++) {
                int after = A[j];
                if(current < after) {
                    count++;
                } else {
                    break;
                }
            }
            sum += (current * count);
        }
        return (int) (sum % 1000000007);
    }
}
