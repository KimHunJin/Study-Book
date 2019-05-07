package AssistantAlpha;

import java.util.*;

public class C {

    public static void main(String[] args) {
        new C().solve();
    }

    private void solve() {

        int[] healths = {300, 200, 500};
        int[][] items = {{1000, 600}, {400, 500}, {300, 100}};

        int[] healths2 = {200, 120, 150};
        int[][] items2 = {{30, 100}, {500, 30}, {100, 400}};

        System.out.println(Arrays.toString(solution(healths, items)));
        System.out.println(Arrays.toString(solution(healths2, items2)));
    }

    class Item {
        int index;
        int power;
        int hp;

        Item(int index, int power, int hp) {
            this.index = index;
            this.power = power;
            this.hp = hp;
        }
    }

    public int[] solution(int[] healths, int[][] items) {
        int[] answer = {};

        List<Item> list = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            list.add(new Item(i + 1, items[i][0], items[i][1]));
        }

        Collections.sort(list, comparator);
        Arrays.sort(healths);

        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < healths.length; i++) {
            int userHP = healths[i];
            for (int j = 0; j < list.size(); j++) {
                int minusHealth = list.get(j).hp;
                int upgradePower = list.get(j).power;

                if (userHP - minusHealth >= 100) {
                    result.add(list.get(j).index);
                    list.remove(list.get(j));
                    break;
                }
            }
        }

        Collections.sort(result);

        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }

    Comparator<Item> comparator = (o1, o2) -> {
        if (o1.power < o2.power) {
            return 1;
        } else if (o1.power == o2.power) {
            return Integer.compare(o1.hp, o2.hp);
        } else {
            return -1;
        }
    };
}
