public class Hanoi {

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.solution(2);
    }

    int[][] answer;
    int count = 0;

    public int[][] solution(int n) {
        int length = (int)(Math.pow(2, n));
        answer = new int[length - 1][2];
        move(n, 1, 2, 3);
        return answer;
    }

    public void move(int n, int from, int by, int to) {
        count++;
        if (n == 1) {
            answer[count-1][0] = from;
            answer[count-1][1] = to;
            return;
        }

        move(n-1, from, to, by);
        answer[count-1][0] = from;
        answer[count-1][1] = to;
        move(n-1, by, from, to);
    }
}
