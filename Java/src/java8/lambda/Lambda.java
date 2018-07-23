package java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Lambda {

    class Apple {
        int weight;

        Apple(int weight) {
            this.weight = weight;
        }

        Apple getWeight() {
            return this;
        }

        int compareTo(Apple o) {
            return Integer.compare(weight, o.weight);
        }
    }

    private void originalMethod() {
        Comparator<Apple> byWeight = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        };
    }

    private void lambdaMethod() {
        // lambda
        Comparator<Apple> byWeight = (Apple o1, Apple o2) ->
                o1.getWeight().compareTo(o2.getWeight());

        // method reference
        Comparator<Apple> weight = (Apple::compareTo);
    }

    /**
     * using lambda
     */
    Runnable r1 = () -> System.out.println("hello world 1");

    /**
     * using anonymous class
     */
    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println("hello world 2");
        }
    };

    private static void process(Runnable r) {
        r.run();
    }

    private void test() {
        process(r1);
        process(r2);
        process(() -> System.out.println("hello world 3")); // using lambda
    }

    /**
     * auto boxing
     * int -> Integer
     * <p>
     * 변환 과정에 비용이 소모됨.
     * 기본형을 감싸는 레퍼가 되어 힙에 저장됨.
     */
    private void autoBoxing() {
        List<Integer> list = new ArrayList<>();
        for (int i = 300; i < 400; i++) {
            list.add(i);
        }
    }

    private interface IntPredicate {
        boolean test(int t);
    }

    /**
     * not boxing
     */
    private void notBoxing() {
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        evenNumbers.test(1000);
    }

    /**
     * boxing
     */
    private void boxing() {
        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 == 1;
        oddNumbers.test(1000);
    }

    private void methodReference() {

        String[] s = new String[]{"3", "4", "2", "1", "5"};
        List<String> list = Arrays.asList(s);

        list.forEach(x -> System.out.println(x)); // lambda
        list.forEach(System.out::println); // method reference
    }


    interface Function<T, R> {
        R apply(T t); // abstract method
    }

    <T, R>List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for(T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }

    private void list() {
        List<Integer> l = map(Arrays.asList("labms", "in", "action"),
                (String::length));

        l.forEach(System.out::println);
    }

    public static void main(String[] args) {
        new Lambda().list();
    }
}
