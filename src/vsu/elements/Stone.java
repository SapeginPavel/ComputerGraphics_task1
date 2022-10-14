package vsu.elements;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Stone {
    private int x, y, size;

    public Stone(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void draw(Graphics2D graphics) {
        Random rnd = new Random(size);
        int points = 20;
        int[] xCoord = new int[points];
        int[] yCoord = {y - size / 10, y - size / 9, y - size / 7, y - size / 8, y -  size / 6, y - size / 5, y - size / 7, y - size / 14, y - size / 8, y - size / 10, y, y, y, y, y, y, y, y, y, y, y};
        for (int i = 0; i < points / 2; i++) {
            xCoord[i] = xCoord[points - i - 1] = x + i * size / 10;
        }
//        yCoord = {y - size / 20, y - size / 18, y - size / 17, y - size / 15, y -  size / 14, y - size / 10, y - size / 12, y - size / 9, y - size / 14, y - size / 17, y, y, y, y, y, y, y, y, y, y, y};
        System.out.println(Arrays.toString(yCoord));
        graphics.fillPolygon(xCoord, yCoord, 10);
    }
}
