package programmers;

import static org.junit.Assert.*;

public class SquareTest {

    Square a;

    public SquareTest() {
        a = new Square();
    }

    @org.junit.Test
    public void solution() {
        String[] s = {"U", "R", "D", "L", "U", "R", "D", "L"};
        int reust = a.solution(s);

        assertEquals(reust, 1);
    }

    @org.junit.Test
    public void solution2() {
        String[] s = {"U", "U", "R", "D", "L", "L", "L", "U", "R", "D", "D", "D", "L", "U", "R", "R", "R", "D", "L", "U"};
        int reust = a.solution(s);

        assertEquals(reust, 5);
    }
}
