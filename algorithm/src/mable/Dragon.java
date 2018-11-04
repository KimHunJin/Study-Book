package mable;

import java.util.ArrayList;
import java.util.List;

public class Dragon {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(7);
        list.add(8);

        Dragon dragon = new Dragon();
        for (int n : list) {
            System.out.println(dragon.solution(n));
        }
    }

    public int solution(int n) {

        int[] eggs = {0, 0};
        int[] dragons = {0, 0, 0, 0};
        int oldDragon = 0;


        eggs[0] = 1;
        for (int i = 1; i <= n; i++) {
            oldDragon += dragons[3];
            dragons[3] = dragons[2];
            dragons[2] = dragons[1];
            dragons[1] = dragons[0];
            dragons[0] = eggs[1];
            eggs[1] = eggs[0];
            eggs[0] = dragons[3] + dragons[2] + dragons[1] + dragons[0];
        }

        return oldDragon + dragons[3] + dragons[2] + dragons[1] + dragons[0] + eggs[1] + eggs[0];
    }
}
