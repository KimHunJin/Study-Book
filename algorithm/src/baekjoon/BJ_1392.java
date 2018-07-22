package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_1392 {
    public static void main(String[] args) {
        new BJ_1392().solve();
    }

    private void solve() {
       try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
           String[] tmp = input(br).split(" ");
           int N = iRead(tmp[0]);
           int Q = iRead(tmp[1]);

           List<Integer> list = new ArrayList<>();
           for(int i=1;i<=N;i++) {
               int time = iRead(input(br));
               for(int j=0;j<time;j++) {
                    list.add(i);
               }
           }

           for(int i=0;i<Q;i++) {
               System.out.println(list.get(iRead(input(br))));
           }

       }catch (IOException ie) {
           ie.printStackTrace();
       }
    }

    private String input(BufferedReader br) {
        String s = "";
        try {
            s = br.readLine();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return s;
    }

    private int iRead(String s) {
        return Integer.parseInt(s);
    }
}
