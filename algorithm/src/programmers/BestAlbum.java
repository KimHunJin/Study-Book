package programmers;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {

        String[] genre = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays= {500, 600, 150, 800, 2500};

        int[] solution = new BestAlbum().solution(genre, plays);

        for (int n : solution) {
            System.out.print(n + " ");
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> countMap = new HashMap();
        Map<Integer, String> reverseMap = new HashMap<>();
        Map<String, ArrayList<Song>> songMap = new HashMap();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            if (countMap.containsKey(genre)) {
                countMap.put(genre, countMap.get(genre) + play);
                songMap.get(genre).add(new Song(i, play));
            } else {
                countMap.put(genre, play);
                ArrayList<Song> list = new ArrayList<>();
                list.add(new Song(i, play));
                songMap.put(genre, list);
            }
        }

        List<Integer> result = new ArrayList<>();

        for (String genreName : countMap.keySet()) {
            reverseMap.put(countMap.get(genreName), genreName);
        }

        Object[] arr = reverseMap.keySet().toArray();

        Arrays.sort(arr, (o1, o2) -> {
            int parseO1 = (int)o1;
            int parseO2 = (int)o2;

            return Integer.compare(parseO2, parseO1);
        });

        for (int i = 0, j=0; i < arr.length; i++, j+=2) {
            String genre = reverseMap.get(arr[i]);
            List<Song> list = songMap.get(genre);
            list.sort((o1, o2) -> {
                if (o1.count > o2.count) {
                    return -1;
                } else if (o1.count < o2.count) {
                    return 1;
                } else {
                    return Integer.compare(o1.index, o2.index);
                }
            });

            if (list.size() < 2) {
                result.add(list.get(0).index);
            } else {
                result.add(list.get(0).index);
                result.add(list.get(1).index);
            }
        }

        int[] answer = new int[result.size()];

        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    class Song {
        int index;
        int count;

        Song(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}
