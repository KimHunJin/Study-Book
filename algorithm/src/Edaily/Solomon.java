package Edaily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solomon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, ArrayList<Integer>> babyMap = new HashMap<>();
        Map<Integer, ArrayList<Integer>> girlMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int girl = sc.nextInt();
            int baby = sc.nextInt();

            if (babyMap.containsKey(baby)) {
                babyMap.get(baby).add(girl);
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(girl);
                babyMap.put(baby, arrayList);
            }

            if (girlMap.containsKey(girl)) {
                girlMap.get(girl).add(baby);
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(baby);
                girlMap.put(girl, arrayList);
            }
        }

        int count = 0;
        for (int key : babyMap.keySet()) {
            if (babyMap.get(key).size() == 1) {
                int girl = babyMap.get(key).get(0);
                ArrayList<Integer> girlList = girlMap.get(girl);
                for(int g : girlList) {
                    babyMap.get(g).remove(girl);
                }
                count++;
            }
        }
    }
}
