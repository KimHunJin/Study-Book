package prev;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] patterns = {"yyyy/M/d", "yy-M-d", "yy년M월d일"};
        List<Sequence> list = new ArrayList<>();

        List<String> arr = new ArrayList<>();

        while (!input.equals("END")) {
            String[] tmp = input.split(" ");

            boolean isDate = false;

            String date = "";
            for(String s : tmp) {
                if(s.charAt(0) == '"') {
                    s = s.substring(1,s.length());
                } else if(s.charAt(s.length()-1)=='"') {
                    s = s.substring(0,s.length()-1);
                }

//                System.out.println(s);
                for(int i = 0; i < patterns.length;i++) {
                    if(isValidDate(new SimpleDateFormat(patterns[i]),s)) {
                        date = s;
                        isDate = true;

                        if(date.contains("/")) {
                            String[] dmp = date.split("/");
                            date = make(dmp);
                        } else if(date.contains("-")) {
                            String[] dmp = date.split("-");
                            date = make(dmp);
                        } else {
                            String[] dmp = date.split("년");
                            String[] dmp2 = dmp[1].split("월");
                            String[] dmp3 = dmp2[1].split("일");

                            if(dmp[0].length() == 2) {
                                dmp[0] = "20" + dmp[0];
                            }
                            if(dmp2[0].length() == 1) {
                                dmp2[0] = "0" + dmp2[0];
                            }
                            if(dmp3[0].length() == 1) {
                                dmp3[0] = "0" + dmp3[0];
                            }

                            date = dmp[0] + dmp2[0] + dmp3[0];
                        }

                        break;
                    }
                }
                if(isDate) {
                    list.add(new Sequence(date, input));
                    arr.add(date);
                    break;
                }
            }

            input = br.readLine();
        }

        Collections.sort(arr);

        for(String s : arr) {
            for(Sequence sq : list) {
                if(s.equals(sq.date)) {
                    System.out.println(sq.word);
                    break;
                }
            }
        }

    }

    static String make(String[] dmp) {
        if(dmp[0].length() == 2) {
            dmp[0] = "20" + dmp[0];
        }
        if(dmp[1].length() == 1) {
            dmp[1] = "0" + dmp[1];
        }
        String k = "";
        for(int j=0;j<dmp[2].length();j++) {

            if(dmp[2].charAt(j) < '0' || dmp[2].charAt(j) >'9') {
                break;
            }
            k += dmp[2].charAt(j);
        }
        if(k.length() == 1) {
            dmp[2] = "0" + k;
        } else {
            dmp[2] = k;
        }
        return dmp[0] + dmp[1] + dmp[2];
    }

    static class Sequence {
        String date;
        String word;

        public Sequence(String date, String input) {
            this.date = date;
            this.word = input;
        }
    }

    static boolean isValidDate(SimpleDateFormat format, String input) {
        try {
            format.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
