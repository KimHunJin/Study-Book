package programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12904
 *
 * 프로그래머스 가장 긴 팰린드롬
 */
class LongestPalindrome {
    public static void main(String[] args) {
        new LongestPalindrome().solve();
    }

    private void solve() {
        String s = "abacde";
        System.out.println(solution(s));
    }

    public int solution(String s) {
        int answer = 0;

        int valid = 1;

        int size = s.length();

        int[][] palindrome = new int[size][size];

        // 길이가 1
        for (int i = 0; i < size; i++) {
            palindrome[i][i] = valid;
        }

        answer = 1;

        // 길이가 2
        for (int i = 0; i < size - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                palindrome[i][i + 1] = valid;
                answer = 2;
            }
        }

        // 길이가 3 이상
        for (int distance = 3; distance <= size; distance++) {
            int lastIndex = size - distance;

            for (int start = 0; start <= lastIndex; start++) {
                int end = start + distance - 1;
                if (s.charAt(start) == s.charAt(end) && palindrome[start + 1][end - 1] == valid) {
                    palindrome[start][end] = valid;
                    answer = Math.max(answer, distance);
                }
            }
        }

        return answer;
    }
}
