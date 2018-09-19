package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C {
    public static void main(String[] args) {
        String[][] relations = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
    }

    private int solution(String[][] relation) {
        int answer = 0;

        Map<Integer, ArrayList<String>> map = new HashMap<>();
        Map<Integer, ArrayList<Integer>> checkMap = new HashMap<>();

        boolean[] isCheck = new boolean[relation[0].length];

        int sero = relation[0].length;
        int garo = relation.length;

        for (int j = 0; j < relation[0].length; j++) {
            map.put(j,new ArrayList<>());
            checkMap.put(j, new ArrayList<>());
            for (int i = 0; i < relation.length; i++) {
                String values = relation[i][j];
                if(map.get(j).contains(values)) {
                    checkMap.get(j).add(i);
                } else {
                    map.get(j).add(values);
                }
            }
        }


        for(int i = 0; i< map.size();i++){
            if(map.get(i).size()==sero) {
                answer++;
                isCheck[i] = true;
            }
        }
        return answer;
    }
}
