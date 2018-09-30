package line.Intern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int n = Integer.parseInt(br.readLine());

            Map<Integer, Integer> map = new HashMap<>();
            Set<Integer> total = new HashSet<>();

            boolean isCheck = true;
            int result = 0;

            for (int i = 0; i < n; i++) {
                if (!isCheck) {
                    result = -1;
                    break;
                }
                final StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                tokenizer.nextToken();
                List<Integer> load = new ArrayList<>();
                while (tokenizer.hasMoreTokens()) {
                    int fork = Integer.parseInt(tokenizer.nextToken());
                    load.add(fork);
                    total.add(fork);
                    // @todo Write your code here.

                }
                for (int k = 0; k < load.size() - 1; k++) {
                    int key = load.get(k);
                    int value = load.get(k + 1);
                    if (map.containsKey(key)) {
                        if (map.get(key) != value) {
                            isCheck = false;
                            break;
                        }
                    } else {
                        map.put(key, value);
                    }
                }
                // @todo Write your code here.
            }
            List<Integer> s = new ArrayList<>();
            if (isCheck) {
                for(int k : total) {
                    if(!map.containsKey(k)) {
                        s.add(k);
                    }
                }
                Collections.sort(s);
                for(int k : s) {
                    System.out.print(k + " ");
                }
            } else {
                System.out.println(result);
            }
            // @todo Write your code here.
        }
    }
}