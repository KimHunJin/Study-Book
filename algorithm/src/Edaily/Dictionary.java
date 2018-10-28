package Edaily;

import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine(), 10);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextLine());
        }

        List<String> list = new ArrayList<>();
        for(String s : set) {
            list.add(s);
        }

        Comparator<String> comparator = (o1, o2) -> {
            int result = 0;
            if (o1.length() == o2.length()) {
                for (int i = 0; i < o1.length(); i++) {
                    if(o1.charAt(i) < o2.charAt(i)) {
                        result = -1;
                        break;
                    } else if(o1.charAt(i) > o2.charAt(i)) {
                        result = 1;
                        break;
                    }
                }
            } else {
                result = Integer.compare(o1.length(),o2.length());
            }
            return result;
        };
        Collections.sort(list, comparator);
        for(String s : list) {
            System.out.println(s);
        }
    }
}
