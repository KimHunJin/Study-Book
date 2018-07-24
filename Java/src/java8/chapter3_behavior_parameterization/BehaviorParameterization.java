package java8.chapter3_behavior_parameterization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BehaviorParameterization {

    private class Apple {
        int weight;
        String color;
        String land;

        public Apple(int weight, String color, String land) {
            this.weight = weight;
            this.color = color;
            this.land = land;
        }

        int getWeight() {
            return weight;
        }

        String getColor() {
            return color;
        }

        String getLand() {
            return land;
        }
    }

    /**
     * 색 or 무게로 사과를 분류하는 필터 메서드.
     * <p>
     * [문제점]
     * flag가 무엇을 의미하는지 알 수 없음.
     * 확장성이 좋지 않음. (무게나 색이 아닌 지역를 추가해야 한다면?)
     *
     * @param inventory : 구분되지 않은 사과를 담고 있는 리스트
     * @param color     : 구분하고 싶은 기준 색
     * @param weight    : 구분하고 싶은 기준 무게
     * @param flag      : 구분하기 위한 방법
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) ||
                    (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }


    /**
     * 어떤 수행을 거쳐 true / false를 반환하는 인터페이스 정의
     */
    interface ApplePredicate {
        boolean test(Apple apple);
    }

    /**
     * 초록 사과만 분류
     */
    private class GreenColorApples implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return "green".equals(apple.getColor());
        }
    }

    /**
     * 한국 사과만 분류
     */
    private class KoreaApples implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return "Korea".equals(apple.getLand());
        }
    }

    /**
     * 무거운 사과만 분류
     */
    public class HeavyWeightApples implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    /**
     * 어떠한 기준으로 사과를 분류하는 필터
     *
     * @param inventory : 정렬되지 않은 사과를 담은 리스트
     * @param p         : 분류하기 위한 방법
     * @return
     */
    private List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    private void getAppleList() {
        List<Apple> inventory = Arrays.asList(
                new Apple(100, "green", "Korea"),
                new Apple(180, "green", "Korea"),
                new Apple(160, "red", "China")
        );
        List<Apple> greenApples = filterApples(inventory, new GreenColorApples());
        List<Apple> koreaApples = filterApples(inventory, new KoreaApples());
    }

    /**
     * 제네릭을 활용하여 확장성 추가
     *
     * @param <T>
     */
    private interface Predicate<T> {
        boolean test(T t);
    }

    /**
     * 제네릭을 활용하여 확장성 / 유연성을 높인다.
     *
     * @param list : 정렬되지 않은 어떤 리스트
     * @param p    : 분류하기 위한 어떤 기법
     * @param <T>  : 분류하기 위한 어떤 주체
     * @return
     */
    private <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    /**
     * 람다와 익명함수를 활용한 유연성 / 확장성 / 간결성 확보
     */
    private void getAnyList() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);

        List<Apple> inventory = new ArrayList<>();
        List<Apple> greenApples = filter(inventory, (Apple apple) -> "green".equals(apple.getColor()));
    }

    public static void main(String[] args) {

    }

}