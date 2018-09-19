package kakao.kakao_2017;

public class Kakao_2017_7 {
    public static void main(String[] args) {
    }

    private int solution(String[] line) {
        int[][] total = new int[line.length][2];

        for (int i = 0; i < line.length; i++) {
            String s = line[i];
            if (s.length() < 1 || s.length() > 2000) return -1;

            int hh = 0;
            int mm = 0;
            int ss = 0;

            String[] tmpLog = s.split(" ");
            String[] tmpTime = tmpLog[1].split(":");

            hh = Integer.parseInt(tmpTime[0]) * 1000;
            mm = Integer.parseInt(tmpTime[1]) * 1000;
            ss = (int) (Double.parseDouble(tmpTime[2]) * 1000.0);

            total[i][0] = (hh * 60 * 60) + (mm * 60) + ss;
            total[i][1] = (int) (Double.parseDouble(tmpLog[2].replace("s", "")) * 1000.0);

        }

        int max = 0;
        for (int i = 0; i < total.length; i++) {
            int tmp = 0;
            int iStart = total[i][0];
            int iEnd = total[i][1];

            for (int[] aTotal : total) {
                int jStart = aTotal[0];
                int jEnd = aTotal[1];

                if (iStart - iEnd + 1 - 999 <= jStart - jEnd + 1 && iStart - iEnd + 1 >= jStart - jEnd + 1) {
                    tmp++;
                } else if (iStart - iEnd + 1 - 999 <= jStart && iStart - iEnd + 1 >= jStart) {
                    tmp++;
                } else if (iStart - iEnd + 1 - 999 > jStart - jEnd && iStart - iEnd + 1 < jStart) {
                    tmp++;
                }
            }
            if (max < tmp) {
                max = tmp;
            }
        }
        return max;
    }
}
