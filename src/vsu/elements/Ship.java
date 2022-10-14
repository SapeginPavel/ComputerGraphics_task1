package vsu.elements;

import vsu.Window;

import java.awt.*;

public class Ship {
    private int x, y, width;
    private boolean moveToRight = true;

    public Ship(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    private void drawWindows(Graphics2D graphics, int xOfCenter, int yOfCenterOfWindow, int diameter, int offset, Color color) {
        Color oldColor = graphics.getColor();
        graphics.setColor(color);
        int distanceBetweenWindows = width / 40;
        for (int i = -2; i < 3; i++) {
            graphics.fillOval(xOfCenter - diameter / 2 + i * distanceBetweenWindows + i * offset, yOfCenterOfWindow, diameter, diameter);
        }
        graphics.setColor(oldColor);
    }

    public void draw(Graphics2D graphics) {
        int xOfCenter = x + width / 2;
        int yOfTop = y - width;
        Color oldColor = graphics.getColor();

        {graphics.setColor(new Color(128, 64, 48));
        int[] xCoord = {x, (x + width), (x + width - width / 7), (x + width / 7)};
        int[] yCoord = {y, y, (y + width / 4), (y + width / 4)};
        graphics.fillPolygon(xCoord, yCoord, 4);

        graphics.fillRect(xOfCenter - width / 50, y - width, width / 25, width); //мачта большого паруса
        graphics.fillRect(x + 4 * width / 5 - width / 80, y - width / 16, width / 40,width / 16); //мачта малого паруса

        graphics.setColor(Color.CYAN);
        int[] xBigSail = {xOfCenter + width / 50 - width / 30, x + width / 2 + width / 50 - width / 30, x + width / 2 + width / 50 - 2 * width / 5 - width / 30};
        int[] yBigSail = {y - width / 16, y - width / 16 - 4 * width / 5, y - width / 16};
        graphics.fillPolygon(xBigSail, yBigSail, 3);

        int[] xSmallSail = {xOfCenter + width / 50 + width / 12, x + width / 2 + width / 50 + width / 12, x + width / 2 + width / 50 + width / 12 + width / 3};
        int[] ySmallSail = {y - width / 16, y - width / 16 - 3 * width / 5, y - width / 16};
        graphics.fillPolygon(xSmallSail, ySmallSail, 3);}

        int[] xOfFlag = {
                xOfCenter + width / 50,
                xOfCenter + width / 50,
                xOfCenter + width / 50 + width / 8,
                xOfCenter + width / 50 + width / 8 - width / 60 - width / 20,
                xOfCenter + width / 50 + width / 8,
                xOfCenter + width / 50,
                xOfCenter + width / 50};
        int[] yOfFlag = {
                yOfTop + width / 50,
                yOfTop + width / 80,
                yOfTop + width / 80,
                yOfTop + width / 50 + width / 40,
                yOfTop + width / 20 + width / 25 - width / 80,
                yOfTop + width / 20 + width / 25 - width / 80,
                yOfTop + width / 20 + width / 50};
        graphics.fillPolygon(xOfFlag, yOfFlag, 7);

        drawWindows(graphics, xOfCenter, y + width / 8 - width / 16, width / 8, width / 8, Color.BLACK);
        drawWindows(graphics, xOfCenter, y + width / 8 - width / 20, width / 10, width / 8, Color.CYAN);

        graphics.setColor(oldColor);
    }

    public void move(int leftBorder, int rightBorder) {
        if (moveToRight) {
            this.x++;
        } else {
            this.x--;
        }
        if ((this.x + width) == rightBorder) { //передавать границы
            moveToRight = false;
        } else if (this.x == leftBorder) {
            moveToRight = true;
        }
    }
}
