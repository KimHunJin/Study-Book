package naver;

import org.jetbrains.annotations.NotNull;

import java.util.PriorityQueue;

public class NaverC {
    public static void main(String[] args) {

// { 문서번호, 요청시간, 페이지 수 }
        int[][] data1 = {{1, 0, 5}, {2, 2, 2}, {3, 3, 1}, {4, 4, 1}, {5, 10, 2}};
        // [1,3,4,2,5]

        int[][] data2 = {{1, 0, 3}, {2, 1, 3}, {3, 3, 2}, {4, 9, 1}, {5, 10, 2}};
//           [1,3,2,4,5]

        int[][] data3 = {{1, 2, 10}, {2, 5, 8}, {3, 6, 9}, {4, 20, 6}, {5, 25, 5}};
//        [1,2,4,5,3]

        NaverC n = new NaverC();

        print(n.solve(data1));
        print(n.solve(data2));
        print(n.solve(data3));
    }

    static void print(int[] data) {
        for (int n : data) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println();
    }

    private int[] solve(int[][] data) {
        int length = data.length;
        int[] answer = new int[length];

        int index = 0;
        int resultIndex = 0;
        int currentTime = 0;

        int[] doc = data[index];
        answer[resultIndex] = doc[0];
        resultIndex++;
        currentTime = doc[1] + doc[2];
        index++;

        PriorityQueue<Docs> pq = new PriorityQueue<>();


        while (true) {
            if (index < length) {
                doc = data[index];
            }


            while (currentTime > doc[1]) {
                pq.add(new Docs(doc[0], doc[1], doc[2]));
                index++;
                if (index >= length) {
                    break;
                } else {
                    doc = data[index];
                }
            }

            System.out.println("size : " + pq.size());


            if (pq.isEmpty()) {
                currentTime = doc[1] + doc[2] - 1;
                index++;
                answer[resultIndex] = doc[0];
                resultIndex++;
            } else {
                Docs next = pq.poll();
                answer[resultIndex] = next.number;
                resultIndex++;
                currentTime += next.pages;
            }


            if (resultIndex == length) {
                break;
            }
        }

        return answer;

    }


    class Docs implements Comparable<Docs> {

        int number;
        int request;
        int pages;

        Docs(int number, int request, int pages) {
            this.number = number;
            this.request = request;
            this.pages = pages;
        }

        @Override
        public int compareTo(Docs o) {
            return Integer.compare(this.pages, o.pages);
        }
    }
}
