package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Time Over
 */
public class BJ_1005_Time_Over {

    private class BuildingRule {
        int number;
        int weight;
        List<Integer> need = new ArrayList<>();

        BuildingRule(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        new BJ_1005_Time_Over().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = iRead(br);
            while (n-- > 0) {
                unitSolution(br);
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private void unitSolution(BufferedReader br) {

        List<BuildingRule> list = makeList(br);
        int destination = iRead(br);

        int start = 0;
        for(int i=1;i<list.size();i++) {
            if(list.get(i).need.size()==0) {
                start = i;
            }
        }

        int result = build(start, list, destination, list.get(destination).weight);
        System.out.println(result);

    }

    private int build(int start, List<BuildingRule> list, int destination, int currentTime) {
        BuildingRule b = list.get(destination);

        if (destination == start) {
            return list.get(start).weight;
        } else {
            int value = 0;
            for (int i = 0; i < b.need.size(); i++) {
                destination = b.need.get(i);
                int time = currentTime + build(start, list, destination, list.get(destination).weight);
                value = value > time ? value : time;
            }
            return value;
        }
    }

    private List<BuildingRule> makeList(BufferedReader br) {
        String[] size = input(br).split(" ");

        int N = convertInt(size[0]);
        int rule = convertInt(size[1]);

        String[] weights = input(br).split(" ");

        List<BuildingRule> buildingInfo = new ArrayList<>();
        buildingInfo.add(new BuildingRule(0, 0));  // 1부터 시작을 위한 dummy

        for (int i = 0; i < N; i++) {
            buildingInfo.add(new BuildingRule(i + 1, convertInt(weights[i])));
        }

        for (int i = 1; i <= rule; i++) {
            String[] info = input(br).split(" ");
            int priority = convertInt(info[0]);
            int later = convertInt(info[1]);

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