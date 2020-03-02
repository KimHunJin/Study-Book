package line2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineF {
    public static void main(String[] args) {
        new LineF().solve();
    }

    private void solve() {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[] tmp = br.readLine().split(" ");

            int n = Integer.parseInt(tmp[0], 10);
            String sort = tmp[1];


            List<Number> list = new ArrayList<>();

            int maxWidth = 0;

            int widthSize = 0;

            for (int i = 0; i < n; i++) {
                tmp = br.readLine().split(" ");
                int width = Integer.parseInt(tmp[0], 10);
                String numbers = tmp[1];

                for (int j = 0; j < numbers.length(); j++) {
                    list.add(new Number(width, numbers.charAt(j) - '0'));
                    widthSize += width;
                    widthSize++;
                }
                maxWidth = Math.max(maxWidth, width);
            }

            int height = maxWidth * 2 - 1;

            String[][] output = new String[height][widthSize];
            for (int i = 0; i < output.length; i++) {
                Arrays.fill(output[i], ".");
            }


            int currentIndex = 0;
            for (int i = 0; i < list.size(); i++) {
                int number = list.get(i).number;
                int size = list.get(i).width;
                int startHeight = 0;
                int numberHeight = size * 2 - 1;


                if (size < maxWidth) {
                    switch (sort) {
                        case "TOP": {
                            startHeight = 0;
                            break;
                        }
                        case "BOTTOM": {
                            startHeight = height - numberHeight;
                            break;
                        }
                        case "MIDDLE": {
                            startHeight = (height - numberHeight) / 2;
                            break;
                        }
                    }
                }


                switch (number) {
                    case 0: {
                        // 가로
                        for (int j = currentIndex; j < currentIndex + size; j++) {
                            output[startHeight][j] = "#";
                            output[startHeight + numberHeight - 1][j] = "#";
                        }
                        for (int j = startHeight; j < startHeight + numberHeight; j++) {
                            output[j][currentIndex] = "#";
                            output[j][currentIndex + size - 1] = "#";
                        }
                        break;
                    }
                    case 1: {
                        for (int j = startHeight; j < startHeight + numberHeight; j++) {
                            output[j][currentIndex + size - 1] = "#";
                        }
                        break;
                    }
                    case 2: {
                        for (int j = currentIndex; j < currentIndex + size; j++) {
                            output[startHeight][j] = "#";
                            output[startHeight + numberHeight / 2][j] = "#";
                            output[startHeight + numberHeight - 1][j] = "#";
                        }
                        for (int j = startHeight; j < startHeight + (numberHeight / 2); j++) {
                            output[j][currentIndex + size - 1] = "#";
                        }
                        for (int j = startHeight + (numberHeight / 2); j < startHeight + numberHeight; j++) {
                            output[j][currentIndex] = "#";
                        }
                        break;
                    }
                    case 3: {
                        // 가로
                        for (int j = currentIndex; j < currentIndex + size; j++) {
                            output[startHeight][j] = "#";
                            output[startHeight + numberHeight / 2][j] = "#";
                            output[startHeight + numberHeight - 1][j] = "#";
                        }
                        // 세
                        for (int j = startHeight; j < startHeight + numberHeight; j++) {
                            output[j][currentIndex + size - 1] = "#";
                        }
                        break;
                    }
                    case 4: {
                        // 왼쪽 세로
                        for (int j = startHeight; j < startHeight + (numberHeight / 2); j++) {
                            output[j][currentIndex] = "#";
                        }
                        // 오른쪽 세로
                        for (int j = startHeight; j < startHeight + numberHeight; j++) {
                            output[j][currentIndex + size - 1] = "#";
                        }
                        // 가운데 가로
                        for (int j = currentIndex; j < currentIndex + size; j++) {
                            output[startHeight + numberHeight / 2][j] = "#";
                        }
                        break;
                    }
                    case 5: {
                        // 가로
                        for (int j = currentIndex; j < currentIndex + size; j++) {
                            output[startHeight][j] = "#";
                            output[startHeight + numberHeight / 2][j] = "#";
                            output[startHeight + numberHeight - 1][j] = "#";
                        }
                        //왼쪽 세로
                        for (int j = startHeight; j < startHeight + (numberHeight / 2); j++) {
                            output[j][currentIndex] = "#";
                        }
                        // 오른쪽 세로
                        for (int j = startHeight + (numberHeight / 2); j < startHeight + numberHeight; j++) {
                            output[j][currentIndex + size - 1] = "#";
                        }
                        break;
                    }
                    case 6: {
                        // 가로
                        for (int j = currentIndex; j < currentIndex + size; j++) {
                            output[startHeight + numberHeight / 2][j] = "#";
                            output[startHeight + numberHeight - 1][j] = "#";
                        }
                        // 왼쪽 세로
                        for (int j = startHeight; j < startHeight + numberHeight; j++) {
                            output[j][currentIndex] = "#";
                        }
                        // 오른쪽 세로
                        for (int j = startHeight + (numberHeight / 2); j < startHeight + numberHeight; j++) {
                            output[j][currentIndex + size - 1] = "#";
                        }
                        break;
                    }
                    case 7: {
                        // 가로
                        for (int j = currentIndex; j < currentIndex + size; j++) {
                            output[startHeight][j] = "#";
                        }
                        // 세로
                        for (int j = startHeight; j < startHeight + numberHeight; j++) {
                            output[j][currentIndex + size - 1] = "#";
                        }
                        break;
                    }
                    case 8: {
                        // 가로
                        for (int j = currentIndex; j < currentIndex + size; j++) {
                            output[startHeight][j] = "#";
                            output[startHeight + numberHeight / 2][j] = "#";
                            output[startHeight + numberHeight - 1][j] = "#";
                        }
                        // 세로
                        for (int j = startHeight; j < startHeight + numberHeight; j++) {
                            output[j][currentIndex] = "#";
                            output[j][startHeight + currentIndex + size - 1] = "#";
                        }
                        break;
                    }
                    case 9: {
                        // 가로
                        for (int j = currentIndex; j < currentIndex + size; j++) {
                            output[startHeight][j] = "#";
                            output[startHeight + height / 2][j] = "#";

                        }
                        //왼쪽 세로
                        for (int j = startHeight; j < startHeight + (numberHeight / 2); j++) {
                            output[j][currentIndex] = "#";
                        }
                        // 오른쪽 세로
                        for (int j = startHeight; j < startHeight + numberHeight; j++) {
                            output[j][currentIndex + size - 1] = "#";
                        }
                        break;
                    }
                }

                currentIndex += size;

                for (int j = 0; j < height; j++) {
                    output[j][currentIndex] = " ";
                }
                currentIndex++;
            }


            for (String[] line : output) {
                String result = "";
                for (String s : line) {
                    result += s;
                }
                System.out.println(result.trim());
            }

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    class Number {
        int width;
        int number;

        Number(int w, int n) {
            this.width = w;
            this.number = n;
        }
    }
}
