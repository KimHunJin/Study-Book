import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class RunLength {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> tree = new PriorityQueue<>(count, Collections.reverseOrder());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int i;

        for (i = 0; i < count; i++) {
            tree.add(Integer.parseInt(st.nextToken()));
        }

        int size = tree.size();
//        for(i=0;i<size;i++) {
//            System.out.println(tree.poll());
//        }

        int max = 0;
        System.out.println("max" + max);
        i = 1;

        System.out.println("for each");
        for (Integer tmp : tree) {
            System.out.println("tmp" + tmp);
            max = (max < tmp) ? tmp : max;
        }

        System.out.println();
        System.out.println("poll");
        for(i=0;i<size;i++) {
            System.out.println(tree.poll());
        }

        System.out.println();
        System.out.println();
        System.out.println(max);

    }
}
