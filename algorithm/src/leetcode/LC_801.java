package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_801 {
    public static void main(String[] args) {

        int[] A = {1, 3, 5, 4};
        int[] B = {1, 2, 3, 7};

        int[] A1 = {0, 3, 5, 8, 9};
        int[] B1 = {2, 1, 4, 6, 9};

        int[] A2 = {0, 7, 8, 10, 10, 11, 12, 13, 19, 18};
        int[] B2 = {4, 4, 5, 7, 11, 14, 15, 16, 17, 20};

        int[] A3 = {1, 8, 4, 6, 7, 8, 16, 18, 19, 29, 25, 26, 35, 31, 38, 35, 37, 41, 39, 43, 48, 49, 46, 47, 50, 52, 54, 55, 63, 58, 67, 63, 69, 71, 74, 73, 76, 77, 80, 78, 79, 80, 86, 87, 90, 93, 95, 96, 97, 100, 101, 105, 106, 108, 108, 109, 116, 111, 119, 121, 122, 124, 130, 125, 126, 127, 128, 140, 144, 135, 148, 151, 143, 154, 155, 157, 160, 156, 158, 159, 168, 170, 163, 173, 175, 176, 177, 180, 177, 182, 183, 184, 185, 190, 191, 194, 194, 195, 196, 200};
        int[] B3 = {7, 3, 12, 14, 19, 22, 24, 26, 27, 21, 30, 31, 28, 36, 33, 39, 40, 38, 42, 43, 44, 45, 50, 55, 56, 57, 58, 61, 56, 64, 60, 68, 70, 71, 72, 75, 74, 75, 77, 81, 82, 83, 81, 84, 91, 93, 95, 96, 99, 100, 102, 103, 104, 107, 113, 114, 110, 118, 112, 113, 114, 115, 124, 132, 133, 134, 135, 131, 134, 145, 137, 140, 152, 144, 150, 151, 154, 163, 165, 166, 160, 161, 172, 164, 168, 171, 172, 173, 181, 183, 184, 187, 189, 191, 192, 193, 195, 198, 199, 197};

        List<AB> list = new ArrayList<>();
//        list.add(new AB(A, B));
//        list.add(new AB(A1, B1));
//        list.add(new AB(A2, B2));
        list.add(new AB(A3, B3));

        LC_801 result = new LC_801();

        for (AB ab : list) {
            System.out.println(result.minSwap(ab.A, ab.B));
        }

    }

    static class AB {
        int[] A;
        int[] B;

        AB(int[] A, int[] B) {
            this.A = A;
            this.B = B;
        }
    }

    public int minSwap(int[] A, int[] B) {

        int size = A.length;
        int[] AA = new int[size + 1];
        int[] BB = new int[size + 1];
        AA[0] = -1;
        BB[0] = -1;
        for (int i = 1; i <= A.length; i++) {
            AA[i] = A[i - 1];
            BB[i] = B[i - 1];
        }
        return Math.min(beforeSwap(AA, BB), afterSwap(AA, BB));
    }

    public int beforeSwap(int[] A, int[] B) {
        int size = A.length;
        int beforeA = A[0];
        int currentA = A[1];
        int beforeB = B[0];
        int currentB = B[1];

        int result = 0;

        for (int i = 2; i < size; i++) {
            int afterA = A[i];
            int afterB = B[i];

            if (afterA <= currentA) {
                // currentA와 currentB 교환
                result++;
                if (currentB <= beforeA) {
                    // afterA와 afterB 교환
                    int tmp = afterA;
                    afterA = afterB;
                    afterB = tmp;

                    // before와 current 유지, after 교환
                    beforeA = currentA;
                    currentA = afterA;
                    beforeB = currentB;
                    currentB = afterB;
                } else {
                    // currentA와 currentB 교환
                    int tmp = currentA;
                    currentA = currentB;
                    currentB = tmp;

                    // before 유지, current 교환, after 유지
                    beforeA = currentA;
                    currentA = afterA;
                    beforeB = currentB;
                    currentB = afterB;
                }
            } else if (afterB <= currentB) {
                // currentB와 currentA 교환
                result++;
                if (currentA <= beforeB) {
                    int tmp = afterA;
                    afterA = afterB;
                    afterB = tmp;

                    // before와 current 유지, after 교환
                    beforeA = currentA;
                    currentA = afterA;
                    beforeB = currentB;
                    currentB = afterB;
                } else {
                    // currentB와 currentA 교환
                    int tmp = currentA;
                    currentA = currentB;
                    currentB = tmp;

                    // before 유지, current 교환, after 유지
                    beforeA = currentA;
                    currentA = afterA;
                    beforeB = currentB;
                    currentB = afterB;
                }
            } else {
                // before 유지, current 유지, after 유지
                beforeA = currentA;
                beforeB = currentB;
                currentA = afterA;
                currentB = afterB;
            }
        }
        return result;
    }

    public int afterSwap(int[] A, int[] B) {
        int size = A.length;

        int beforeA = A[0];
        int currentA = A[1];
        int beforeB = B[0];
        int currentB = B[1];

        int result = 0;

        for (int i = 2; i < size; i++) {
            int afterA = A[i];
            int afterB = B[i];

            if (afterA <= currentA) {
                result++;
                // afterA와 afterB 교환
                int tmp = afterA;
                afterA = afterB;
                afterB = tmp;

                beforeA = currentA;
                currentA = afterA;
                beforeB = currentB;
                currentB = afterB;
            } else if (afterB <= currentB) {
                result++;
                int tmp = afterA;
                afterA = afterB;
                afterB = tmp;

                beforeA = currentA;
                currentA = afterA;
                beforeB = currentB;
                currentB = afterB;
            } else {
                beforeA = currentA;
                currentA = afterA;
                beforeB = currentB;
                currentB = afterB;
            }

        }

        return result;
    }
}
