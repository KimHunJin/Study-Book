package winter;

import java.util.ArrayList;
import java.util.List;

public class Cookie {
    public static void main(String[] args) {
        Cookie c = new Cookie();
        int[] caseA = {1,1,2,3};
        int[] caseB = {1,2,4,5};
        int[] caseC = {1,1};

        List<int[]> list = new ArrayList<>();
        list.add(caseA);
        list.add(caseB);
        list.add(caseC);

        for(int[] l : list) {
            System.out.println(c.solution(l));
        }
    }

    public int solution(int[] cookie) {
        int answer = 0;

        int size = cookie.length-1;
        if(cookie.length == 1) {
            return 0;
        }

        while (true) {
            for (int i = 0; i < cookie.length - size; i++) {
                int a = makeA(cookie, i, size);
                int b = 0;
                for (int j = i + size; j < cookie.length; j++) {
                    b += cookie[j];
                    if(a == b) {
                        answer = a;
                        break;
                    } else if(a < b) {
                        break;
                    }
                }
            }
            size--;
            if(answer != 0) {
                break;
            }
            if(size <= 1) {
                break;
            }
        }

        return answer;
    }

    private int makeA(int[] cookie, int startIndex, int size) {
        int result = 0;
        for (int i = startIndex; i < startIndex + size; i++) {
            result += cookie[i];
        }
        return result;
    }
}
