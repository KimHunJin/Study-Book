package naver;

import java.util.regex.Pattern;

public class NaverA {
    public static void main(String[] args) {


        String pattern = "^[a-z.]+@[a-z]+\\.(com|net|org)$";

        String test = "a.@c.com";
        String test2 = "...@a.comnet";

        System.out.println(test.matches(pattern));
        System.out.println(test2.matches(pattern));

    }
}
