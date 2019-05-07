package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1181 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine(), 10);

        Set<String> set = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        Comparator<String> comparator = (o1, o2) -> {
            if (o1.length() < o2.length()) {
                return -1;
            } else if (o1.length() > o2.length()) {
                return 1;
            } else {
                return compare(o1, o2);
            }
        };

        List<String> list = new ArrayList<>(set);

        list.sort(comparator);

        for (String s : list) {
            System.out.println(s);
        }
    }

    static int compare(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) < s2.charAt(i)) {
                return -1;
            } else if(s1.charAt(i) > s2.charAt(i)) {
                return 1;
            }
        }
        return 0;
    }
}
