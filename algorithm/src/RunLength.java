/**
 * algorithm run-length
 *
 * 문자열 압축 알고리즘.
 *
 * input
 * qwwwwwwweeeeerrtyyyyyqqqqwEErTTT
 *
 * output
 * 1q7w5e2r1t5y4q1w2E1r3T
 */
public class RunLength {
    public static void main(String[] args) {
        new RunLength().solve();
    }

    private void solve() {
        String input = "qwwwwwwweeeeerrtyyyyyqqqqwEErTTT";
        System.out.println(algorithmRunLength(input));
    }

    private String algorithmRunLength(String input) {
        StringBuilder sb = new StringBuilder();
        int size = input.length();

        for(int i = 0 ;i<size; i++) {
            int runLength = 1;
            char c = input.charAt(i);
            while (i + 1 < size && c == input.charAt(i + 1)) {
                runLength++;
                i++;
            }
            sb.append(runLength);
            sb.append(c);
        }

        return sb.toString();
    }
}
