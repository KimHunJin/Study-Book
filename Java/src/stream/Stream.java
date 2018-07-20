package stream;

import java.util.stream.IntStream;

public class Stream {
    public static void main(String[] args) {
        int a = 100;
        int b = 30;
        int[] array = {1, 2, 3, 4, 5, 6};

        for (int i = 0; i < 5; i++) {
//            boolean is = IntStream.of(array).anyMatch(n -> 3 > (a + b - n));

            int c = a + 1;
            int d = b + 2;

//            System.out.println(is);
            System.out.println(IntStream.of(array).anyMatch(n -> n > c - d));


            a++;
            b--;
        }
    }

    private void test() {
        int a = 100;
        int b = 200;
        int[] arr = {1,2,3,4,5};
        for(int i = 0 ; i< 5 ; i++) {
        }
    }
}