package programmers;

public class SkillTree {
    public int solution(String command, String[] buttons, int[] scores) {
        int answer = 0;

        int[] dp = new int[command.length()];

        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            for (int j = 0; j < buttons.length; j++) {
                String button = buttons[j];
                if (isFind(c, button)) {
                    String commandInput = subCommand(command, i, i + button.length());
                    if (button.equals(commandInput)) {
                        int score = scores[j];
                        int index = i + button.length() - 1;
                        int eveScore = i - 1 < 0 ? 0 : dp[i - 1];
                        int sum = eveScore + score;
                        dp[index] = maxScore(dp[index], sum);
                    }
                }
            }
            int eveScore = i - 1 < 0 ? 0 : dp[i - 1];
            dp[i] = maxScore(dp[i], eveScore + 1);
            answer = dp[i];
        }

        return answer;
    }

    protected int maxScore(int score1, int score2) {
        return Math.max(score1, score2);
    }

    protected String subCommand(String command, int startIndex, int lastIndex) {
        if (command.length() < lastIndex) {
            return null;
        }
        return command.substring(startIndex, lastIndex);
    }

    protected boolean isFind(char c, String buttons) {
        return buttons.charAt(0) == c;
    }
}
