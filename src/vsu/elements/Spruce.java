package vsu.elements;

import java.awt.*;

public class Spruce {
    private int x, y, height;

    public Spruce(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }

    public void draw(Graphics2D graphics) {
        Color oldColor = graphics.getColor();

        graphics.setColor(new Color(101, 67, 33));
        int heightOfStump = (int) (height * 0.15);
        int xRight = x + (int) (height * 0.05) / 2;
        graphics.fillRect(x, y, (int) (height * 0.05), heightOfStump);

        graphics.setColor(new Color (20, 156, 124));

        int h = (height - heightOfStump) / 3;
        int w = (int) (h / 1.35);
        int[] xLower = {xRight, xRight - w, xRight + w};
        int[] sSecond = {xRight, xRight - (int) (w * 0.8), xRight + (int) (w * 0.8)};
        int[] xUpper = {xRight, xRight - (int) (w * 0.7), xRight + (int) (w * 0.7)};
        int[] yLower = {y - h - (int) (h * 0.4), y, y};
        int[] yMedium = {y - (int) (h * 2) - (int) (h * 0.2), y - h - (int) (h * 0.1), y - h - (int) (h * 0.1)};
        int[] yUpper = {y - height + heightOfStump, y - h * 2, y - h * 2};
        graphics.fillPolygon(xLower, yLower, 3);
        graphics.fillPolygon(sSecond, yMedium, 3);
        graphics.fillPolygon(xUpper, yUpper, 3);

        graphics.setColor(oldColor);
    }
}
