package line;

import java.util.*;

public class IP {

    public static final String NO = "aa";

    public static void main(String[] args) {
        String s = "25525512235";
        int length = s.length();
        List<String> numberList = new ArrayList<>();

        HashMap<Integer, ArrayList<String>> map = new HashMap<>();

        ArrayList<String> l = new ArrayList<>();
        l.add("1111");
        map.put(4, l);

        l = new ArrayList<>();
        l.add("2111");
        l.add("1211");
        l.add("1121");
        l.add("1112");
        map.put(5, l);

        l = new ArrayList<>();
        l.add("3111");
        l.add("1311");
        l.add("1131");
        l.add("1113");

        l.add("2211");
        l.add("2121");
        l.add("2112");
        l.add("1221");
        l.add("1122");
        l.add("1212");
        map.put(6, l);

        l = new ArrayList<>();
        l.add("3211");
        l.add("3121");
        l.add("3112");

        l.add("2311");
        l.add("2131");
        l.add("2113");

        l.add("1123");
        l.add("1132");
        l.add("1231");
        l.add("1321");
        l.add("1213");
        l.add("1312");

        l.add("2221");
        l.add("2122");
        l.add("2212");
        l.add("1222");

        map.put(7, l);

        l = new ArrayList<>();
        l.add("3311");
        l.add("3113");
        l.add("3131");
        l.add("1331");
        l.add("1313");
        l.add("1133");

        l.add("3221");
        l.add("3212");
        l.add("3122");

        l.add("2132");
        l.add("2231");
        l.add("2312");
        l.add("2213");
        l.add("2123");
        l.add("2321");

        l.add("1322");
        l.add("1232");
        l.add("1223");

        l.add("2222");
        map.put(8, l);

        l = new ArrayList<>();
        l.add("3321");
        l.add("3123");
        l.add("3132");
        l.add("3213");
        l.add("3231");
        l.add("3312");

        l.add("1233");
        l.add("1323");
        l.add("1332");

        l.add("2133");
        l.add("2313");
        l.add("2331");

        l.add("3222");
        l.add("2322");
        l.add("2232");
        l.add("2223");
        map.put(9, l);

        l = new ArrayList<>();
        l.add("3331");
        l.add("3133");
        l.add("3313");
        l.add("1333");

        l.add("3322");
        l.add("3232");
        l.add("3223");
        l.add("2323");
        l.add("2233");
        l.add("2332");
        map.put(10, l);

        l = new ArrayList<>();
        l.add("3332");
        l.add("3233");
        l.add("3323");
        l.add("2333");
        map.put(11, l);

        l = new ArrayList<>();
        l.add("3333");
        map.put(12, l);


        List<String> v = map.get(length);

        for(int i =0; i<v.size();i++) {
            String t = v.get(i);
            String result = "";
            int index = 0;
            int count = t.charAt(0)-'0';
            for(int j =0; j<length; j++) {
                if(count == j && j != length) {
                    result += ".";
                    index++;
                    count = count + (t.charAt(index)-'0');
                }
                result = result + s.charAt(j);
            }
            numberList.add(result);
        }


        List<String> result = new ArrayList<>();
        for(int i =0 ;i < numberList.size();i++) {
            String[] t = numberList.get(i).split("\\.");
            boolean isCheck = true;
            for(int j=0;j<4;j++) {
                if(Integer.parseInt(t[j]) > 255) {
                    isCheck = false;
                    break;
                }
            }
            if(isCheck) {
                result.add(numberList.get(i));
            }
        }

        Collections.sort(result);

        for(String m : result) {
            System.out.println(m);
        }

    }
}
