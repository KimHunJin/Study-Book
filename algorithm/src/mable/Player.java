package mable;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        int[] a = {5,3,4,6,2,1};
        int[] b = {6,2,3,4,1,5};

        list.add(a);
        list.add(b);

        Player player = new Player();
        for(int[] t : list) {
            System.out.println(player.solution(t));
        }
    }

    public int solution(int[] status) {
        List<Integer> teamNumber = new ArrayList<>();
        teamNumber.add(status[0]);
        for (int i = 1; i < status.length; i++) {
            int currentRate = status[i];
            boolean isRow = true;
            for (int j = 0; j < teamNumber.size(); j++) {
                if(currentRate > teamNumber.get(j)) {
                    isRow = false;
                    break;
                }
            }
            if(isRow) {
                teamNumber.add(currentRate);
            }
        }
        return teamNumber.size();
    }
}
