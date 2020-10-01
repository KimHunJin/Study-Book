package kakao.kakao_2020_winter;

import java.util.ArrayList;
import java.util.HashMap;

public class Query {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        System.out.println(new Query().solution(info, query));
    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        long[] infoCodingScore = new long[info.length];
        long[] infoValue = new long[info.length];

        ArrayList<Integer>[] arr = new ArrayList[46];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        HashMap<String, Integer> language = new HashMap<>();
        language.put("java", 1);
        language.put("cpp", 16);
        language.put("python", 31);

        HashMap<String, Integer> job = new HashMap<>();
        job.put("backend", 0);
        job.put("frontend", 1);

        HashMap<String, Integer> year = new HashMap<>();
        year.put("senior", 0);
        year.put("junior", 1);

        HashMap<String, Integer> sourFood = new HashMap<>();
        sourFood.put("pizza", 0);
        sourFood.put("chicken", 1);

        for (int i = 0; i < info.length; i++) {
            String[] infos = info[i].split(" ");
            int score = Integer.parseInt(infos[4]);
            arr[0].add(score);

            int lang = language.get(info[0]);
            arr[lang].add(score);

            int jobStart = lang + 1;
            int jobResult = jobStart + job.get(infos[1]);
            arr[jobResult].add(score);

            int yearStart = jobStart + 3;

        }

        for (int i = 0; i < query.length; i++) {

        }

        return answer;
    }

    private void makeTree() {

    }
}

