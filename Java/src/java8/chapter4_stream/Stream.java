package java8.chapter4_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

    class Dish {
        private final String name;
        private final boolean vegetarian;
        private final int caloires;
        private final Type type;

        public Dish(String name, boolean vegetarian, int caloires, Type type) {
            this.name = name;
            this.vegetarian = vegetarian;
            this.caloires = caloires;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public boolean isVegetarian() {
            return vegetarian;
        }

        public int getCaloires() {
            return caloires;
        }

        public Type getType() {
            return type;
        }

    }

    public enum Type {
        MEAT, FISH, OTHER
    }

    List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Type.MEAT),
            new Dish("beef", false, 700, Type.MEAT),
            new Dish("chicken", false, 400, Type.MEAT),
            new Dish("french fries", true, 530, Type.OTHER),
            new Dish("rice", true, 350, Type.OTHER),
            new Dish("season fruit", false, 120, Type.OTHER),
            new Dish("pizza", true, 550, Type.OTHER),
            new Dish("prawns", false, 300, Type.FISH),
            new Dish("salmon", false, 450, Type.FISH)
    );

    private void makeSteam() {
        List<String> threeHighCaloricDishNames =
                menu.stream() // menu를 스트림으로 호출
                    .filter(d -> d.getCaloires() > 300) // 300보다 높은 칼로리 추출
                    .map(Dish::getName) // 이름 추출
                    .limit(3) // 선착순 3개
                    .collect(Collectors.toList()); // 리스트로 반환

        System.out.println(threeHighCaloricDishNames);

    }


    public static void main(String[] args) {
        new Stream().makeSteam();
    }
}