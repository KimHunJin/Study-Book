package leetcode;

public class LC_1689 {

    public static void main(String[] args) {
        new LC_1689().solve();
    }

    private void solve() {
        String n = "27346209830709182346";
        System.out.println(minPartitions(n));
    }

    public int minPartitions(String n) {
        int max = 0;
        for (int i=0; i<n.length(); i++) {
            int number = n.charAt(i) - '0';
            max = max > number ? max : number;
        }

        return max;
    }
}
