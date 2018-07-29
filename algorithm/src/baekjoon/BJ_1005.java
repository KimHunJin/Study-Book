package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 위상정렬 문제
 *
 * [ solution ] // 로직
 * 필요 조건이 없는 것 부터 queue에 담는다.
 * 큐에 담겨진 수를 제거했을 때 필요한 조건이 없는 것을 queue에 담는다.
 * 큐에 담겨진 수를 제거하기 전 큐에 들어있는 수들의 weight가 가장 큰 수를 더한다.
 * 큐에 찾고자 하는 수가 들어와 poll되기 전까지 반복한다.
 *
 * 1 -> 2
 * 1 -> 3
 * 2 -> 4
 * 3 -> 4
 *
 * queue(1)
 *  -> poll(1)
 *  -> time + time(1)
 *
 * queue(2,3)
 *  -> poll(2) poll(3)
 *  -> time + Max(time(2), time(3))
 *
 * queue(4)
 *  -> poll(4)
 *  -> time + time(4)
 */
public class BJ_1005 {
    public static void main(String[] args) {

    }

    private void solve() {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = iRead(br);
            for(int i=0;i<n;i++) {
                unit_solve(br);
            }
        }catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private void unit_solve(BufferedReader br) {
        String[] dmp = input(br).split(" ");
        int n = convertInt(dmp[0]);
        int k = convertInt(dmp[1]);

        int[] map = new int[n+1];
        dmp = input(br).split(" ");
        for(int i=0;i<dmp.length;i++) {
            map[i+1] = convertInt(dmp[i]);
        }

    }

    private int convertInt(String s) {
        return Integer.parseInt(s);
    }

    private int iRead(BufferedReader br) {
        return Integer.parseInt(input(br));
    }

    private String input(BufferedReader br) {
        String s = "";
        try {
            s = br.readLine();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return s;
    }
}
