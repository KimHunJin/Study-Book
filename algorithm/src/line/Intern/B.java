package line.Intern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B {
    public static void main(String[] args) throws IOException {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int N = Integer.parseInt(br.readLine());
            int i;
            int[][] array = new int[100][100];
            int max = 0;
            for (i = 0; i < N; i++) {
                final StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(tokenizer.nextToken());
                int y = Integer.parseInt(tokenizer.nextToken());
                int w = Integer.parseInt(tokenizer.nextToken());
                int h = Integer.parseInt(tokenizer.nextToken());
                // @todo Write your code here

                for (int j = x; j < w; j++) {
                    for (int k = y; k < h; k++) {
                        array[j][k]++;
                        if (array[j][k] > max) {
                            max = array[j][k];
                        }
                    }
                }
            }

            System.out.println(max);
            // @todo Write your code here.
        }
    }
}