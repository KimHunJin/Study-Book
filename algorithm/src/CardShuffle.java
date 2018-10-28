import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CardShuffle {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardCount = Integer.parseInt(br.readLine()); // 카드 숫자
        int[] card = new int[cardCount];
        int[] sequence = new int[cardCount];
        int p = Integer.parseInt(br.readLine()); // 몇번 수행

        int[] shuffleInfo = new int[p];
        for (int i = 0; i < p; i++) {
            shuffleInfo[i] = Integer.parseInt(br.readLine()); // 몇장이 위에 있는지.
        }

        for (int i = 0; i < card.length; i++) {
            card[i] = i + 1;
            sequence[i] = i + 1;
        }

        boolean isFirst = true;

        int[] result = new int[cardCount];
        for (int i = 0; i < shuffleInfo.length; i++) {
            int start = 0;
            int end = cardCount - 1;

            int count = cardCount;
            int n = shuffleInfo[i];
            while (count > n * 2) {
                count -= (n * 2);
                start += n;
                end -= n;
            }
            int begin = start;
            int changeCount = 0;
            while (start >= 0) {

                if (begin != start) {

                    for (int j = start; j < start + n; j++) {
                        if (j < 0) {
                            j = 0;
                        }
                        sequence[j] = changeCount;
                        changeCount++;
                    }

                    for (int j = end; j < end + n; j++) {
                        if (j >= cardCount) {
                            break;
                        }
                        sequence[j] = changeCount;
                        changeCount++;
                    }
                    start -= n;
                    end += n;
                } else {
                    for (int j = start; j <= end; j++) {
                        sequence[j] = changeCount;
                        changeCount++;
                    }
                    start -= n;
                    end += 1;
                }

            }
            if (isFirst) {
                for (int j = 0; j < cardCount; j++) {
                    result[sequence[j]] = j + 1;
                }
                isFirst = false;
            } else {
                int[] dmp = new int[cardCount];
                for(int j=0;j<cardCount;j++) {
                    dmp[sequence[j]] = result[j];
                }
                for(int j=0;j<cardCount;j++) {
                    result[j] = dmp[j];
                }
            }
        }
        for(int r : result) {
            System.out.print(r + " ");
        }
    }
}
