package baekjoon;

import java.util.Scanner;

public class BJ_2159 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine(), 10);
        XY start = new XY();
        String[] tmp = sc.nextLine().split(" ");
        start.x = Integer.parseInt(tmp[0]);
        start.y = Integer.parseInt(tmp[1]);

        XY xy[] = new XY[n];
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().split(" ");
            xy[i].x = Integer.parseInt(t[0]);
            xy[i].y = Integer.parseInt(t[1]);
        }


    }

    static class XY {
        int x;
        int y;
    }
}
