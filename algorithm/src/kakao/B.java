package kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class B {
    public static void main(String[] args) {
       int[] result= new B().solution(5, new int[]{2,1,2,6,2,4,3,3});
       for(int a : result) {
           System.out.println(a);
       }
    }

    private int[] solution(int N, int[] stages) {
        int[] r = new int[N + 1];
        int peoples = stages.length;
        for (int stage : stages) {
            if(stage < N+1) {
                r[stage]++;
            }
        }
        List<Info> list = new ArrayList<>();
        for (int i = 1; i < r.length; i++) {
            int currentPeople = r[i];
            list.add(new Info(i, (double)currentPeople / peoples));
            peoples -= currentPeople;
        }

        Collections.sort(list, comparator);


        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i).index;
        }
        return answer;
    }

    Comparator<Info> comparator = new Comparator<Info>() {
        @Override
        public int compare(Info o1, Info o2) {
            if (o1.sts > o2.sts) {
                return -1;
            } else if (o1.sts < o2.sts) {
                return 1;
            } else {
                return Integer.compare(o1.index, o2.index);
            }
        }
    };

    class Info {
        int index;
        double sts;

        Info(int index, double sts) {
            this.index = index;
            this.sts = sts;

        }
    }
}
