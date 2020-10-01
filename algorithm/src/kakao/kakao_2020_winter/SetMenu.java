package kakao.kakao_2020_winter;

import java.util.*;

public class SetMenu {

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        String[] result = {"AC", "ACDE", "BCFG", "CDE"};

        String[] sol = new SetMenu().solution(orders, course);

        for (String s : sol) {
            System.out.println(s);
        }
        System.out.println();

        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = {2, 3, 5};
        String[] result2 = {"AC", "ACDE", "BCFG", "CDE"};

        String[] sol2 = new SetMenu().solution(orders2, course2);

        for (String s : sol2) {
            System.out.println(s);
        }
        System.out.println();

        String[] orders3 = {"XYZ", "XWY", "WXA"};
        int[] course3 = {2, 3, 4};
        String[] result3 = {"WX", "XY"};

        String[] sol3 = new SetMenu().solution(orders3, course3);

        for (String s : sol3) {
            System.out.println(s);
        }
        System.out.println();
    }

    Map<String, Integer> map = new HashMap();

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        for (String order : orders) {
            for (int j = 0; j < course.length; j++) {
                int n = order.length();
                int r = course[j];
                boolean[] visit = new boolean[n];
                if (n >= r) {
                    String[] c = order.split("");
                    Arrays.sort(c);
                    String changeOrder = "";
                    for (String s: c) {
                        changeOrder += s;
                    }
                    combination(changeOrder, visit, 0, n, r);
                }
            }
        }

        List<String> result = new ArrayList<>();
        List<Menu>[] resultCourse = new ArrayList[11];
        for (int i = 0; i < 11; i++) {
            resultCourse[i] = new ArrayList<>();
        }

        for (String key : map.keySet()) {
            int count = map.get(key);
            System.out.println("key is : " + key + " count is : " + count);
            if (count > 1) {
                resultCourse[key.length()].add(new Menu(count, key));
            }
        }

        for (List<Menu> menus : resultCourse) {
            if (menus.size() > 0) {
                menus.sort(new Comparator<Menu>() {
                    @Override
                    public int compare(Menu o1, Menu o2) {
                        return Integer.compare(o2.count, o1.count);
                    }
                });
                int maxCount = menus.get(0).count;
                for (Menu m : menus) {
                    if (m.count == maxCount) {
                        result.add(m.course);
                        System.out.println("result is : " + m.course + " count is : " + m.count);
                    }
                }
            }
        }

        Collections.sort(result);

        int size = result.size();
        answer = new String[size];
        for (int i = 0; i < size; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    private void combination(String orders, boolean[] visit, int start, int n, int r) {
        if (r == 0) {
            String result = "";
            for (int i = 0; i < n; i++) {
                if (visit[i]) {
                    result += orders.charAt(i);
                }
            }

            result = result.trim();

            if (map.containsKey(result)) {
                int count = map.get(result);
                count++;
                map.put(result, count);
            } else {
                map.put(result, 1);
            }
        }

        for (int i = start; i < n; i++) {
            visit[i] = true;
            combination(orders, visit, i + 1, n, r - 1);
            visit[i] = false;
        }
    }

    class Menu {
        int count;
        String course;

        Menu(int count, String course) {
            this.count = count;
            this.course = course;
        }
    }
}
