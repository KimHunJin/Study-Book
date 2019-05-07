package baekjoon;

import java.io.*;
import java.util.Scanner;

public class BJ_1212 {
    public static void main(String[] args){
        new BJ_1212().solve();
    }

    private void solve() {
        try(
                BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();

//            String result = "";

            if(s.equals("0")) {
                System.out.println(0);
                return;
            }

            String[] cs = {
                    "000",
                    "001",
                    "010",
                    "011",
                    "100",
                    "101",
                    "110",
                    "111"
            };

            String[] cs2 = {
                    "",
                    "1",
                    "10",
                    "11",
                    "100",
                    "101",
                    "110",
                    "111"
            };


            int c = s.charAt(0) -'0';

            sb.append(cs2[c]);

//            result += cs2[c];

            for (int i = 1; i < s.length(); i++) {
                c = s.charAt(i) - '0';
                sb.append(cs[c]);
            }

            System.out.println(sb.toString());
        } catch (IOException ie) {
            ie.printStackTrace();
        }

    }
}
