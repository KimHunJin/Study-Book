package baekjoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 백준 온라인 저지 1015
 *
 * P[0], P[1], ...., P[N-1]은 0부터 N-1까지(포함)의 수를 한 번씩 포함하고 있는 수열이다.
 * 수열 P를 길이가 N인 배열 A에 적용하면 길이가 N인 배열 B가 된다. 적용하는 방법은 B[P[i]] = A[i]이다.
 *
 * 배열 A가 주어졌을 때, 수열 P를 적용한 결과가 비내림차순이 되는 수열을 찾는 프로그램을 작성하시오.
 * 비내림차순이란, 각각의 원소가 바로 앞에 있는 원소보다 크거나 같을 경우를 말한다.
 * 만약 그러한 수열이 여러개라면 사전순으로 앞서는 것을 출력한다.
 *
 * ex)
 * input
 * 3
 * 2 3 1
 *
 * output
 * 1 2 0
 *
 * input
 * 50
 * 794 615 121 609 849 831 791 871 821 418 626 66 420 418 497 48 70 294 677 257 963 466 223 944 699 478 521 223 820 813 347 944 918 194 387 463 835 820 180 502 482 338 58 258 629 136 203 585 87 518
 *
 * output
 * 37 31 5 30 44 42 36 45 41 18 32 2 20 19 25 0 3 14 34 12 49 22 10 47 35 23 28 11 39 38 16 48 46 8 17 21 43 40 7 26 24 15 1 13 33 6 9 29 4 27
 *
 * solution
 * a : 2 3 1
 * p : 1 2 0
 * --> sort(a) : 1 2 3
 * sort(a) + select(p) => a
 * sort(a)[p[0]] = sort(a)[1] = 2
 * sort(a)[p[1]] = sort(a)[2] = 3
 * sort(a)[p[2]] = sort(a)[0] = 1
 *
 * {2 3 1} == a
 *
 * caution
 * p is not duplication value
 */
public class BJ_1015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] b = a.clone();
        Arrays.sort(b);

        boolean[] isUsed = new boolean[n];

        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i] == b[j] && !isUsed[j]) {
                    p[i] = j;
                    isUsed[j] = true;
                    break;
                }
            }
        }

        for (int i : p) {
            System.out.print(i + " ");
        }
    }
}
