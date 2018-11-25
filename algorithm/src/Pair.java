import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Pair {
    public static void main(String[] args) {
        int[] a = {6, 1, 3, 46, 1, 3, 9};
        long k = 47;
        System.out.println(numberOfPairs(a, k));

        int[] b = {7, 6, 6, 3, 9, 3, 5, 1};
        long k2 = 12;
        System.out.println(numberOfPairs(b, k2));
    }

    private static int numberOfPairs(int[] a, long k) {
        Arrays.sort(a);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            int first = a[i];
            int need = (int) (k - a[i]);
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] == need) {
                    set.add(first);
                    set.add(need);
                    break;
                } else if(a[j] < need) {
                    break;
                }
            }
        }

        return set.size()/2;
    }
}
