package programmers;

import java.util.HashMap;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12904
 * <p>
 * 프로그래머스 가사검색
 */
public class LyricsSearch {

    public static void main(String[] args) {
        new LyricsSearch().solve();
    }

    private void solve() {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        int[] sol = solution(words, queries);

        for (int n : sol) {
            System.out.print(n + " ");
        }
    }

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        HashMap<Integer, Trie> trie = new HashMap<>();
        HashMap<Integer, Trie> reverseTrie = new HashMap<>();

        for (String word : words) {
            int length = word.length();
            if (!trie.containsKey(length)) {
                trie.put(length, new Trie());
            }
            if (!reverseTrie.containsKey(length)) {
                reverseTrie.put(length, new Trie());
            }
            trie.get(length).addNode(word);
            reverseTrie.get(length).addNode(reverseWord(word));
        }

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int length = query.length();
            // 처음이 ?로 시작하면 뒤에서부터 확인한다.
            if (query.charAt(0) == '?') {
                Trie findReverseTrie = reverseTrie.get(length);
                if (findReverseTrie != null) {
                    answer[i] = findReverseTrie.find(reverseWord(query));
                }
            } else {
                Trie findTrie = trie.get(length);
                if (findTrie != null) {
                    answer[i] = findTrie.find(query);
                }
            }
        }

        return answer;
    }

    private String reverseWord(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    private class Trie {
        TrieNode rootNode;

        Trie() {
            rootNode = new TrieNode();
        }

        void addNode(String str) {
            TrieNode currentNode = rootNode;
            currentNode.count++;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (!currentNode.childNode.containsKey(c)) {
                    currentNode.childNode.put(c, new TrieNode());
                }

                currentNode = currentNode.childNode.get(c);
                currentNode.count++;
            }
        }

        int find(String str) {
            TrieNode currentNode = rootNode;
            if (str.charAt(0) == '?') {
                return currentNode.count;
            }

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '?') {
                    return currentNode.count;
                }

                currentNode = currentNode.childNode.get(c);
                if (currentNode == null) {
                    return 0;
                }
            }
            return 0;
        }
    }

    class TrieNode {
        int count;

        HashMap<Character, TrieNode> childNode = new HashMap();
    }
}
