package naverB;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class B {
    public static void main(String[] args) {
        new B().solve();
    }

    private void solve() {
        System.out.println(solution(1000000));
    }

    private long solution(int n) {

        long answer = 0;

        Set<Long> list = new LinkedHashSet<>();

        Stack<Long> stack = new Stack<>();

        long number = 2;
        list.add(number);
        stack.push(number);
        int index = 2;
        while (list.size() <= (n * 2)) {
            index++;
            Stack<Long> nextStack = new Stack<>();
            while (!stack.isEmpty()) {
                long k = stack.pop();
                long value = k * index;
                list.add(value);
                nextStack.push(value);
                nextStack.push(Long.parseLong(index+""));
            }
            stack = nextStack;
        }

        List<Long> result = new ArrayList<>(list);

        Collections.sort(result);

        for (long l: result) {
            System.out.println("is : " + l);
        }

        answer = Math.min(n * (n+1), result.get(n-1));

        return answer;
    }

}
