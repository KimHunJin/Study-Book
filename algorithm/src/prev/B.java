package prev;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();

        int n = Integer.parseInt(input, 10);

        String[] maxDmp = br.readLine().trim().split(" ");
        String[] currentDmp = br.readLine().trim().split(" ");
        int count = Integer.parseInt(br.readLine().trim(), 10);

        int[] max = new int[n];
        int[] current = new int[n];

        for (int i = 0; i < n; i++) {
            max[i] = Integer.parseInt(maxDmp[i]);
            current[i] = Integer.parseInt(currentDmp[i]);
            if(max[i] < current[i]) {
                System.out.println(-1);
                return;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            long sum = count + current[i];
            count = (int) (sum / (max[i] +1));
            current[i] = (int) (sum % (max[i] +1));
        }

        String result = "";
        for(int i =0; i<n; i++) {
            result += current[i];
        }

        System.out.println(result);

    }
}
