package goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GiftExchange {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input, 10);

        while (n-- > 0) {
            String[] temp = br.readLine().split(" ");
            long limit = Long.parseLong(temp[0]);
            long general = Long.parseLong(temp[1]);

            long maxLimit = limit / 5;
            long result = 0;
            general = general + limit % 5;

            long maxGeneral = general / 7;

            if (maxGeneral >= maxLimit) {
                System.out.println(maxLimit);
                continue;
            }

            result = ((7 * maxLimit) - general) / 12;
            System.out.println(maxLimit - result);

//            while (general < maxLimit * 7) {
//                maxLimit--;
//                general = general + 5;
//            }
//            result = maxLimit;
//            System.out.println(result);
        }
    }

}
