package AssistantAlpha;

import java.util.*;

public class B {


    public static void main(String[] args) {
        new B().solve();
    }

    public static final int CANCEL = 0;
    public static final int RESERVATION = 1;
    public static final int WAITER = 2;


    private void solve() {

        int[][] cus = {{1, 1}, {2, 1}, {3, 1}, {2, 0}, {2, 1}};
        int[][] cus2 = {{2, 1}, {1, 1}, {3, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 1}};

        System.out.println(Arrays.toString(solution(cus, 2)));
    }

    public int[] solution(int[][] customer, int K) {
        int[] answer;
        int size = customer.length;

        // 1 is reservation
        // 0 is cancel

        List<Integer> reservations = new ArrayList<>();
        List<Integer> waiters = new ArrayList<>();

        // 1 예약자
        // 2 대기자
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            int isReservation = customer[i][1];
            int id = customer[i][0];
            if (isReservation == RESERVATION) {
                if (reservations.size() == K) {
                    waiters.add(id);
                    map.put(id, WAITER);
                } else {
                    reservations.add(id);
                    map.put(id, RESERVATION);
                }
            } else {
                if (map.get(id) == RESERVATION) {
                    reservations.remove((Object)id);
                    map.put(id, CANCEL);
                    if (waiters.size() > 0) {
                        int w = waiters.get(0);
                        waiters.remove(0);
                        reservations.add(w);
                        map.put(w, RESERVATION);
                    }
                } else {
                    waiters.remove((Object)id);
                    map.put(id, CANCEL);
                }
            }

        }


        Collections.sort(reservations);
        answer = new int[reservations.size()];

        for (int i = 0; i < reservations.size(); i++) {
            answer[i] = reservations.get(i);
        }

        return answer;
    }
}
