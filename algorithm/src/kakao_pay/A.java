package kakao_pay;

import javafx.css.Match;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(new A().solution(s));

    }

    public int solution(String s) {
        Pattern p1 = Pattern.compile("^010-\\d{4}-\\d{4}$\n");
        Pattern p2 = Pattern.compile("010\\d{8}");
        Pattern p3 = Pattern.compile("^\\+82-10-\\d{4}-\\d{4}");

        Matcher m1 = p1.matcher(s);

        if(m1.find()) {
            return 1;
        }

        Matcher m2 = p2.matcher(s);
        if(m2.find()) {
            return 2;
        }

        Matcher m3 = p3.matcher(s);
        if(m3.find()) {
            return 3;
        }

        return -1;
    }
}
