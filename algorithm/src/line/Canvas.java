package line;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Canvas {
    public static void main(String[] args) throws IOException {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            final int width = Integer.parseInt(tokenizer.nextToken());
            final int height = Integer.parseInt(tokenizer.nextToken());
            final int rotation = Integer.parseInt(tokenizer.nextToken());
            final int magnification = Integer.parseInt(tokenizer.nextToken());
            final int shiftX = Integer.parseInt(tokenizer.nextToken());
            final int shiftY = Integer.parseInt(tokenizer.nextToken());

            int changeX = width;
            int changeY = height;

            if(rotation % 2 == 1) {
                changeX = height;
                changeY = width;
            }


            int startX = (20-changeX) / 2;
            int startY = (20-changeY) / 2;

            startX = startX + shiftX;
            startY = startY + shiftY;

            int lastX = startX + changeX -1;
            int lastY = startY + changeY -1;



            for (int i = 0; i < changeX; i++) {
                tokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < changeY; j++) {
                    int pixel = Integer.parseInt(tokenizer.nextToken());
                }
            }

        }
    }
}