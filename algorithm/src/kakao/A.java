package kakao;

import java.util.*;

public class A {

    private static final String ENTER = "Enter";
    private static final String LEAVE = "Leave";
    private static final String CHANGE = "Change";

    public static void main(String[] args) {

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        String[] result = new A().solution(record);

        for (String s : result) {
            System.out.println(s);
        }

    }

    private String[] solution(String[] record) {

        Map<String, String> map = new HashMap<>();
        List<Info> list = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String[] tmp = record[i].split(" ");
            String check = tmp[0];
            String id = tmp[1];
            if (check.equals(ENTER) || check.equals(CHANGE)) {
                String name = tmp[2];
                map.put(id, name);
            }
            list.add(new Info(check, id));
        }


        List<String> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String check = "";
            if (list.get(i).check.equals(ENTER)) {
                check = "들어왔습니다.";
            } else if(list.get(i).check.equals(LEAVE)){
                check = "나갔습니다.";
            } else {
                continue;
            }
            String s = map.get(list.get(i).id) + "님이 " + check;
            result.add(s);
        }

        String[] answer = new String[result.size()];
        answer = result.toArray(answer);

        return answer;
    }

    class Info {
        String check;
        String id;

        Info(String check, String id) {
            this.check = check;
            this.id = id;
        }
    }
}

