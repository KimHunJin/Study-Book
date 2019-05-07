package line.threedayintern;

import java.io.*;

public class Rectangle {
    public static void main(String[] args) {
        new Rectangle().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            long size = Long.parseLong(br.readLine(), 10);

            long index = (long) Math.sqrt(size);

            for (long i = index; i >= 0; i--) {
                if (size % i == 0) {
                    long k = size / i;
                    System.out.println(Math.abs(k - i));
                    break;
                }
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
