package Edaily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Rope {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        Map<Integer, ArrayList<City>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            tmp = sc.nextLine().split(" ");
            int start = Integer.parseInt(tmp[0]);
            int des = Integer.parseInt(tmp[1]);
            int time = Integer.parseInt(tmp[2]);

            if (map.containsKey(start)) {
                map.get(start).add(new City(des, time));
            } else {
                City city = new City(des, time);
                ArrayList<City> arrayList = new ArrayList<>();
                arrayList.add(city);
                map.put(start, arrayList);
            }

            if (map.containsKey(des)) {
                map.get(des).add(new City(start, time));
            } else {
                City city = new City(start, time);
                ArrayList<City> arrayList = new ArrayList<>();
                arrayList.add(city);
                map.put(des, arrayList);
            }
        }
    }

    static class City {
        int destination;
        int time;

        City(int destination, int time) {
            this.destination = destination;
            this.time = time;
        }
    }
}
