package programmers;

public class MakeBigNumber {

    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int size = number.length();
        int maxNumberLength = size - k;

        int startIndex = 0;
        int currentLength = 0;
        while (true) {

            int max = 0;
            int maxIndex = startIndex;
            int loopCount = size - (maxNumberLength - currentLength) + 1;

            for (int i = startIndex; i < loopCount; i++) {
                int indexNumber = Integer.parseInt(number.charAt(i) + "");
                if (max < indexNumber) {
                    max = indexNumber;
                    maxIndex = i;
                }
            }

            answer.append(number.charAt(maxIndex));
            currentLength++;
            startIndex = maxIndex + 1;

            if (answer.length() == maxNumberLength) {
                break;
            }
        }

        return answer.toString();
    }
}
