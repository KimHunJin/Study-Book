package goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _Stack {

    private enum StackCallType {
        POP,
        PUSH,
        ETC
    }

    private static final String UNDERFLOW = "underflow";
    private static final String OVERFLOW = "overflow";
    private static final int STACK_MAX_SIZE = 10;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int n = Integer.parseInt(input, 10);

        List<Integer> s = new ArrayList<>();

        while (n-- > 0) {
            input = br.readLine();
            StackCallType type = callType(Integer.parseInt(input, 10));
            if (type == StackCallType.ETC) {
                break;
            }

            if (type == StackCallType.PUSH) {
                int number = Integer.parseInt(br.readLine(), 10);
                if (s.size() == STACK_MAX_SIZE) {
                    System.out.println(OVERFLOW);
                } else {
                    s.add(number);
                }
            }

            if (type == StackCallType.POP) {
                if (s.isEmpty()) {
                    System.out.println(UNDERFLOW);
                } else {
                    s.remove(s.size() - 1);
                }
            }
        }

        for(int item: s) {
            System.out.print(item + " ");
        }
    }

    private static StackCallType callType(int n) {
        switch (n) {
            case 0: return StackCallType.PUSH;
            case 1: return StackCallType.POP;
            default: return StackCallType.ETC;
        }
    }
}
