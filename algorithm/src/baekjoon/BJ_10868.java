package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10868 {
    public static void main(String[] args) {
        new BJ_10868().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tmp = br.readLine().split(" ");
            int n = Integer.parseInt(tmp[0], 10);
            int m = Integer.parseInt(tmp[1], 10);

            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(br.readLine(), 10);
            }

            SegmentTree segmentTree = new SegmentTree(array, n);


            System.out.println();
            for(int p: segmentTree.segmentArr){
                System.out.print(p+ " ");
            }

            System.out.println();

            for (int i = 0; i < m; i++) {
                tmp = br.readLine().split(" ");
                int start = Integer.parseInt(tmp[0], 10);
                int end = Integer.parseInt(tmp[1], 10);

                int min = array[start];
                for (int j = start; j < end-1; j++) {
                    if (min > array[j]) {
                        min = array[j];
                    }
                }
//                System.out.println(min);
            }

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    class SegmentTree {

        int[] segmentArr;

        SegmentTree(int[] arr, int n) {
            this.segmentArr = new int[n * 4];
            init(arr, 0, n - 1, 1);
        }

        int init(int[] arr, int left, int right, int node) {

            if (left == right) {

                return segmentArr[node] = arr[left];
            }

            int mid = (left + right) / 2;

            segmentArr[node] = init(arr, left, mid, node * 2);
            segmentArr[node] = init(arr, mid + 1, right, node * 2 + 1);

            return segmentArr[node];
        }
    }
}
