package winter;

import java.util.ArrayList;
import java.util.List;

public class Move {
    public static void main(String[] args) {
        String a = "ULURRDLLU";
        String b = "LULLLLLLU";
        String c = "RRRRRRRRR";
        String d = "DDDDDDDDD";
        String e = "UUUUUUUUU";

        List<String> l = new ArrayList<>();
        l.add(a);
        l.add(b);
        l.add(c);
        l.add(d);
        l.add(e);

        Move m = new Move();

        for (String s : l) {
            System.out.println(m.solution(s));
        }
    }

    public int solution(String dirs) {
        int answer = 0;
        boolean[][] map = new boolean[21][21];
        int x = 10;
        int y = 10;

        map[x][y] = true;
        XY xy = new XY(x, y);

        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            xy = make(xy, c);
            if (map[xy.x][xy.y] == false) {
                answer++;
                map[xy.x][xy.y] = true;
                xy = make(xy, c);
                map[xy.x][xy.y] = true;
            } else {
                xy = make(xy, c);
            }
        }

        return answer;
    }

    private XY make(XY xy, char dir) {
        if (dir == 'U') {
            xy.y--;
            if (xy.y < 0) {
                xy.y = 0;
            }
        }
        if (dir == 'D') {
            xy.y++;
            if (xy.y > 20) {
                xy.y = 20;
            }
        }
        if (dir == 'L') {
            xy.x--;
            if (xy.x < 0) {
                xy.x = 0;
            }
        }
        if (dir == 'R') {
            xy.x++;
            if (xy.x > 20) {
                xy.x = 20;
            }
        }
        return xy;
    }

    class XY {
        int x;
        int y;

        XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
