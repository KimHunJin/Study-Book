package programmers;

import java.util.HashSet;
import java.util.Set;

public class PhoneBook {

    public static void main(String[] args) {
        String[] phoneBook = {"119", "97674223", "1195524421"};
        String[] phoneBook2 = {"123", "456", "789"};
        String[] phoneBook3 = {"12","123", "1235", "567" , "88"};

        PhoneBook pb = new PhoneBook();

        System.out.println(pb.solution(phoneBook));
        System.out.println(pb.solution(phoneBook2));
        System.out.println(pb.solution(phoneBook3));
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Set<String> phoneBook = new HashSet();

        for(String s: phone_book) {
            if (phoneBook.contains(s)) {
                answer = false;
                break;
            }

            for(String p: phoneBook) {
                if (p.length() >= s.length()) {
                    String r = p.substring(0, s.length());
                    if (r.equals(s)) {
                        return false;
                    }
                } else {
                    String r = s.substring(0, p.length());
                    if (r.equals(p)) {
                        return false;
                    }
                }
            }

            phoneBook.add(s);
        }
        return answer;
    }
}
