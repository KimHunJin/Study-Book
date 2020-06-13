package programmers;

import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class SkillTreeTest {

    SkillTree skillTree;

    public SkillTreeTest() {
        skillTree = new SkillTree();
    }

    @Test
    public void case1() {
        String command = "<v>AB^CYv^XAZ";
        String[] buttons = {"v>AB^CYv^XA", "<v>A", "^XAZ", "Yv^XA", ">AB^"};
        int[] scores = {50, 18, 20, 30, 25};
        int result = 59;


        int solution = skillTree.solution(command, buttons, scores);
        assertEquals(result, solution);
    }

    @Test
    public void case2() {
        String command = "ABCXYZ";
        String[] buttons = {"BCXY"};
        int[] scores = {2};
        int result = 6;

        int solution = skillTree.solution(command, buttons, scores);
        assertEquals(result, solution);
    }

    @Test
    public void case3() {
        String command = "ABCXYZ";
        String[] buttons = {"CXYZ","AB"};
        int[] scores = {2, 3};
        int result = 7;

        int solution = skillTree.solution(command, buttons, scores);
        assertEquals(result, solution);
    }
}
