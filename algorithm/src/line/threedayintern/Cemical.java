package line.threedayintern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Cemical {
    public static void main(String[] args) {
        new Cemical().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s = br.readLine();

            List<String> english = new ArrayList<>();
            List<String> number = new ArrayList<>();
            String t = "";
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                t += c;
                if (c >= '0' && c <= '9') {
                    if(c=='0') {
                        t = "";
                    } else {
                        if(c=='1' && i+1 < s.length() && s.charAt(i+1)=='0') {
                            t+='0';
                        }
                        number.add(t);
                        t = "";
                    }
                } else {
                    if (i + 1 < s.length()) {
                        if ((s.charAt(i + 1) <= 'Z' && s.charAt(i + 1) >= 'A') || (s.charAt(i + 1) >= '0') && s.charAt(i + 1) <= '9') {
                            english.add(t);
                            t = "";
                        }
                    } else {
                        english.add(t);
                    }
                }
            }

            if (english.size() != number.size()) {
                System.out.println("error");
            } else {
                for (int i = 0; i < english.size(); i++) {
                    if (number.get(i).equals("1")) {
                        number.set(i,"");
                    }
                    System.out.print(english.get(i)+number.get(i));
                }
            }

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
