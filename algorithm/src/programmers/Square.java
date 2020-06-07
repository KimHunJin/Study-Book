package programmers;

public class Square {

    public static void main(String[] args) {

    }

    public int solution(String[] moves) {
        int answer = 0;

        int[] moveX = {0, 0, 1, -1};
        int[] moveY = {1, -1, 0, 0};

        int x = 500;
        int y = 500;

        int[][] map = new int[1001][1001];
        map[x][y] = 1;

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < 2; j++) {
                switch (moves[i]) {
                    case "R": {
                        y++;
                        break;
                    }
                    case "L": {
                        y--;
                        break;
                    }
                    case "U": {
                        x++;
                        break;
                    }
                    case "D": {
                        x--;
                        break;
                    }
                }
                map[x][y] = 1;
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[j][i] == 0) {
                    boolean isSquare = true;
                    for (int k = 0; k < moveX.length; k++) {
                        int movingX = i + moveX[k];
                        int movingY = j + moveY[k];
                        if (movingX < 0) {
                            isSquare = false;
                            break;
                        }
                        if (movingY < 0) {
                            isSquare = false;
                            break;
                        }
                        if (movingX >= map[0].length) {
                            isSquare = false;
                            break;
                        }
                        if (movingY >= map.length) {
                            isSquare = false;
                            break;
                        }
                        if (map[movingY][movingX] != 1) {
                            isSquare = false;
                            break;
                        }
                    }
                    if (isSquare) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
