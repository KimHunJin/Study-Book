package leetcode;

public class LC_801 {
    public static void main(String[] args) {

        int[] A = {1,3,5,4};
        int[] B = {1,2,3,7};

        int[] A1 ={0,3,5,8,9};
        int[] B1 = {2,1,4,6,9};

        int[] A2 = {0,7,8,10,10,11,12,13,19,18};
        int[] B2 = {4,4,5,7,11,14,15,16,17,20};

        LC_801 result = new LC_801();

        System.out.println(result.minSwap(A2,B2));
    }

    public int minSwap(int[] A, int[] B) {

        int size = A.length;
        int beforeA = A[0];
        int beforeB = B[0];
        // 뒤에꺼 바꾸기
        int beforeC = 0;
        int afterC = 0;
        for (int i = 1; i < size; i++) {
            if(beforeA >= A[i]) {
                beforeA = B[i];
                beforeB = A[i];
                afterC ++;
            } else if(beforeB >= B[i]) {
                beforeA = B[i];
                beforeB = A[i];
                afterC ++;
            } else {
                beforeA = A[i];
                beforeB = B[i];
            }
        }

        // 앞에꺼 바꾸기
        beforeA = A[0];
        beforeB = B[0];
        for(int i=1;i <size; i++) {
            if(beforeA >= A[i]) {
                beforeC ++;
            } else if(beforeB >= B[i]) {
                beforeC++;
            }
            beforeA = A[i];
            beforeB = B[i];
        }

        System.out.println(beforeC);
        System.out.println(afterC);

        return Math.min(beforeC, afterC);
    }
}
