package kakao.kakao_2017;

public class Kakao_2017_1 {
    public static void main(String[] args) {
        new Kakao_2017_1().solve();
    }

    private void solve() {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};


        String[][] s = result(n, arr1, arr2);

        for (String[] ss : s) {
            for(String sss: ss) {
                System.out.print(sss + " ");
            }
            System.out.println();
        }
    }

    private String[][] result(int n, int[] arr1, int[] arr2) {
        String[][] r = new String[n][n];
        for (int i = 0; i < n; i++) {
            StringBuilder s1 = new StringBuilder(Integer.toBinaryString(arr1[i]));
            StringBuilder s2 = new StringBuilder(Integer.toBinaryString(arr2[i]));

            int size1 = n - s1.length();
            int size2 = n - s2.length();

            for (int j = 0; j < size1; j++) {
                s1.insert(0, "0");
            }
            for (int j = 0; j < size2; j++) {
                s2.insert(0, "0");
            }

            for (int j = 0; j < n; j++) {
                if(s1.charAt(j) == '1' || s2.charAt(j) == '1') {
                    r[i][j] = "#";
                }else {
                    r[i][j] = " ";
                }
            }
        }

        return r;
    }
}
