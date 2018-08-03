package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InputForm {

    public static void main(String[] args) {
        new InputForm().init();
    }

    /**
     * 문제 풀이는 여기서
     * @param br
     */
    private void test(BufferedReader br) {

        int a = iRead(br);
        System.out.println(a);
        int b = iRead(br);
        System.out.println(b);
        int c = iRead(br);
        System.out.println(c);

        String d = readLine(br);
        System.out.println(d);
    }


    private void init() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ) {
            test(br);
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private StringTokenizer st = new StringTokenizer("");

    private String readLine(BufferedReader br) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(br.readLine());
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return sb.toString();
    }

    private int iRead(BufferedReader br) {
        return Integer.parseInt(next(br));
    }

    private long lRead(BufferedReader br) {
        return Long.parseLong(next(br));
    }

    private double dRead(BufferedReader br) {
        return Double.parseDouble(next(br));
    }

    private String next(BufferedReader br) {
        while (!st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }
        return st.nextToken();
    }
}
