package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Cal {


    public static void main(String[] args) throws IOException {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            final int N = Integer.parseInt(br.readLine());


            List<Integer> numbers = new ArrayList<>();
            List<Character> oper = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                final StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                while (tokenizer.hasMoreTokens()) {
                    final String token = tokenizer.nextToken();

                }
            }
        }
    }

}
