package leetcode;

public class LC_877 {

    public static void main(String[] args) {
        new LC_877().solve();
    }

    private void solve() {
        int[] piles = {5, 3, 4, 5};
        System.out.println(stoneGame(piles));
    }

    public boolean stoneGame(int[] piles) {
        int currentBeforeIndex = 0;
        int currentEndIndex = piles.length - 1;

        int alex = 0;
        int lee = 0;

        int loopCount = piles.length / 2;

        while (loopCount-- > 0) {

            if (isBeforeScoreLarge(piles, currentBeforeIndex, currentEndIndex)) {
                alex += piles[currentBeforeIndex];
                currentBeforeIndex++;
            } else {
                alex += piles[currentEndIndex];
                currentEndIndex--;
            }

            if (isBeforeScoreLarge(piles, currentBeforeIndex, currentEndIndex)) {
                lee += piles[currentBeforeIndex];
                currentBeforeIndex++;
            } else {
                lee += piles[currentEndIndex];
                currentEndIndex--;
            }
        }

        return alex != lee;
    }

    private boolean isBeforeScoreLarge(int[] piles, int beforeIndex, int afterIndex) {
        return piles[beforeIndex] > piles[afterIndex];
    }
}
