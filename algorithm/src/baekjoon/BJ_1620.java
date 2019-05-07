package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BJ_1620 {
    public static void main(String[] args) throws IOException {
        new BJ_1620().solve();
    }

    private void solve() throws IOException{
        PocketBook b = new PocketBook();

        b.process();
    }
    class PocketBook {
        ArrayList<String> book = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pageLength;
        int problemLength;
        String[] answerArr;

        Map<String, Integer> nameToIndexMap = new HashMap<>();
        Map<Integer, String> indexToNameMap = new HashMap<>();

        // 생성자 ( 길이 받기 )
        PocketBook() throws IOException {
            String[] tmp = br.readLine().split(" ");
            pageLength = Integer.parseInt(tmp[0],10);//n
            problemLength = Integer.parseInt(tmp[1],10);//m
        }

        // 도감에 포켓몬 추가
        private void addPocketInfo() throws IOException {
            for (int i = 0; i < pageLength; i++) {
                String name = br.readLine();
                int index = i+1;
                nameToIndexMap.put(name, index);
                indexToNameMap.put(index, name);
            }
        }

        // 포켓몬 이름으로 인덱스 찾기
        private String findPocket(String name) {
            return nameToIndexMap.get(name).toString();
        }

        // 인덱스로 포켓몬 이름찾기
        private String findPocket(int index) {
            return indexToNameMap.get(index);
        }

        // 실행메서드
        void process() throws IOException {
            addPocketInfo();
            for (int i = 0; i < problemLength; i++) {
                String question = br.readLine();

                if(isString(question))
                    System.out.println(findPocket(question));
                else
                    System.out.println(findPocket(Integer.parseInt(question)));
            }
        }


        // 문자열 인지 확인
        boolean isString(String s) {
            if(s.charAt(0) >= '0' && s.charAt(0) <='9') {
                return false;
            }
            return true;
        }
    }
}
