package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_1005 {
    public static void main(String[] args) {
        new BJ_1005().solution();
    }

    private class Build {
        int weight;
        //        List<Integer> available = new ArrayList<>();
        List<Integer> need = new ArrayList<>();

        Build(int weight) {
            this.weight = weight;
        }
    }

    private void solution() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = iRead(br);
            for (int i = 0; i < n; i++) {
                unitSolution(br);
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private List<Build> list;

    private void unitSolution(BufferedReader br) {
        list = makeList(br);
        int destination = iRead(br);

        int result = calTime(destination);
        System.out.println(result);
    }

    private int calTime(int start) {
        if (list.get(start).need.size() == 0) {
            return list.get(start).weight;
        } else {
            int max = 0;
            for (int i = 0; i < list.get(start).need.size(); i++) {
                max = Integer.max(max, list.get(start).weight + calTime(list.get(start).need.get(i)));
            }
            return max;
        }
    }

    private List<Build> makeList(BufferedReader br) {
        String[] size = input(br).split(" ");

        int N = convertInt(size[0]);
        int rule = convertInt(size[1]);

        String[] weights = input(br).split(" ");

        List<Build> buildingInfo = new ArrayList<>();
        buildingInfo.add(new Build(0));  // 1부터 시작을 위한 dummy

        for (int i = 0; i < N; i++) {
            buildingInfo.add(new Build(convertInt(weights[i])));
        }

        for (int i = 1; i <= rule; i++) {
            String[] info = input(br).split(" ");
            int priority = convertInt(info[0]);
            int later = convertInt(info[1]);

//            buildingInfo.get(priority).available.add(later);
            buildingInfo.get(later).need.add(priority);
        }
        return buildingInfo;
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