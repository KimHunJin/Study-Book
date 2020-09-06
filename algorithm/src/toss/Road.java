package toss;

import java.io.*;
import java.util.*;

class Road {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int n = Integer.parseInt(input);

        Map<String, RoadInfo> map = new HashMap();
        List<RoadInfo> list = new ArrayList();

        for (int i = 0; i < n; i++) {
            String[] infos = br.readLine().split("\\.");
            for (int j = 0; j < infos.length - 1; j++) {
                int priority = j;
                String name = infos[j];
                if (map.containsKey(name)) {
                    map.get(name).callCount++;
                    if (map.get(name).callCount == n) {
                        list.add(map.get(name));
                    }
                } else {
                    map.put(name, new RoadInfo(name, priority, 1));
                }
            }
        }

        Collections.sort(list, co);

        String result = "";
        for (int i = 0; i < list.size(); i++) {
            RoadInfo r = list.get(i);
            result += r.name;
            if (i < list.size() -1) {
                result += ".";
            }
        }

        if (list.isEmpty()) {
            System.out.println("없음");
            return;
        }

        System.out.println(result);
    }

    static Comparator<RoadInfo> co = (o1, o2) -> {
        return Integer.compare(o1.priority, o2.priority);
    };

    static class RoadInfo {
        String name;
        int priority;
        int callCount;

        RoadInfo(String name, int priority, int callCount) {
            this.name = name;
            this.priority = priority;
            this.callCount = callCount;
        }
    }
}
