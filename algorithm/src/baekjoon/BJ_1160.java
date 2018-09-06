package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ_1160 {
    public static void main(String[] args) {
        new BJ_1160().solve();
    }

    private void solve() {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            long[] arr = input(br);
            long m = arr[0];
            long a = arr[1];
            long c = arr[2];
            long x = arr[3];
            long n = arr[4];
            long g = arr[5];

            // make Xn
            // Xn+1 = (aXn + c) mod m

            List<Long> list = new ArrayList<>();
            list.add(x);
            long count = 0;

            long beforeX;
            long afterX;


            beforeX = x;

            while(true) {

                afterX = beforeX * a;
                afterX = afterX + c;
                afterX = afterX % m;

                count++;
                if(count == n){
                    break;
                } else {
                    beforeX = afterX;
                }
            }

            // print xn mod g
            afterX = afterX % g;
            System.out.println(afterX);


        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private long[] input(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
    }
}
