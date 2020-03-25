package programmers;

import java.util.HashMap;
import java.util.Map;

public class Disguise {
    public static void main(String[] args) {

        String[][] dis = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(new Disguise().solution(dis));
    }

    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap();
        for (int i=0; i<clothes.length; i++) {
            String[] cloth = clothes[i];
            String kind = cloth[1];

            if (map.containsKey(kind)) {
                map.put(kind, map.get(kind) +1);
            } else {
                map.put(kind, 1);
            }
        }

        for (Integer n: map.values()) {
            answer *= (n + 1);
        }
        answer = answer - 1;
        return answer;
    }
}
