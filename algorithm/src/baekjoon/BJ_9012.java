package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine(), 10);


        while (n-- > 0) {
            String s = br.readLine();

            if(s.length()%2==1) {
                System.out.println("NO");
                continue;
            }

            List<Integer> list = new ArrayList<>();
            boolean isOK = true;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '(') {
                    list.add(1);
                } else {
                    if(list.size() == 0) {
                        isOK = false;
                        break;
                    }
                    list.remove(list.size()-1);
                }
            }
            if(list.size() != 0) {
                isOK = false;
            }
            if(isOK) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
