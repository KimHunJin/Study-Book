package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LC_299 {

    public static void main(String[] args) {
        String A = "1123";
        String B = "0111";
        System.out.println(new LC_299().getHint(A, B));
    }

    public String getHint(String secret, String guess) {
        String s = "";
        try {
            Map<Character, ArrayList<Integer>> map = new HashMap<>();
            int A = 0;
            int B = 0;

            int[] counts = new int[10];

            for (int i = 0; i < secret.length(); i++) {
                char c = secret.charAt(i);
                counts[c - '0']++;
                if (map.containsKey(c)) {
                    map.get(c).add(i);
                } else {
                    ArrayList<Integer> index = new ArrayList<>();
                    index.add(i);
                    map.put(c, index);
                }
            }

            for (int i = 0; i < guess.length(); i++) {
                char c = guess.charAt(i);
                if (map.containsKey(c)) {
                    if (map.get(c).contains(i)) {
                        A++;
                        counts[c - '0']--;
                    } else {
                        B++;
                        counts[c - '0']--;
                    }

                    while (counts[c - '0'] < 0) {
                        B--;
                        counts[c - '0']++;
                    }
                }
            }

             s = A + "A" + B + "B";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
