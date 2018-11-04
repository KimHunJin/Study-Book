package mable;

import java.util.ArrayList;
import java.util.List;

public class StringSum {

    static class Test {
        String s1;
        String s2;

        Test(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }
    }

    public static void main(String[] args) {
        StringSum stringSum = new StringSum();

        List<Test> list = new ArrayList<>();

        list.add(new Test("ababc", "abcdab"));

        list.add(new Test("abcdab", "ababc"));


        for(Test t: list) {
             System.out.println(stringSum.solution(t.s1, t.s2));
        }
    }

    public int solution(String s1, String s2) {
        int length = s1.length() + s2.length();

        int s1Size = s1.length();
        int s2Size = s2.length();

        int shortSize = s1Size > s2Size ? s2Size : s1Size;

        int max = 0;
        for (int i = 1; i <= shortSize; i++) {

            String s1Front = s1.substring(0, i);
            String s1Back = s1.substring(s1.length() - i, s1.length());
            String s2Front = s2.substring(0, i);
            String s2Back = s2.substring(s2.length() - i, s2.length());

            // s1 앞 s2 뒤
            if (s1Front.equals(s2Back)) {
                max = i;
            }

            // s1뒤 s2 앞
            if (s1Back.equals(s2Front)) {
                max = i;
            }
        }

        length = length - max;

        return length;
    }
}
