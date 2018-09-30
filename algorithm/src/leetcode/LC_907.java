package leetcode;

public class LC_907 {

    public static void main(String[] args) {
        int[] A = {3, 1, 2 ,4};
        System.out.println(new LC_907().sumSubarrayMins(A));
    }

    public int sumSubarrayMins(int[] A) {
        long sum = 0;
        for(int i=0;i <A.length;i++) {
            sum += A[i];
            int max = A[i];
            for(int j=i+1; j<A.length;j++) {
                if(max < A[j]) {
                    sum += max;
                } else {
                    max = A[j];
                    sum += max;
                }
            }
        }
        return (int) (sum % 1000000007);
    }
}
