package vsu.elements;

import java.awt.*;

public class Cloud {
    private int xStart, yStart, width, x, y;

    public Cloud(int xStart, int yStart, int width) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.width = width;
        x = xStart;
        y = yStart;
    }

    public void draw(Graphics2D graphics) {

        Color oldColor = graphics.getColor();
        graphics.setColor(Color.PINK);
        graphics.fillOval(x, y, (int) (width * 0.32), (int) (width * 0.32));
        graphics.fillOval((int) (x + width * 0.17), (int) (y - width * 0.11), (int) (width * 0.46), (int) (width * 0.46));
        graphics.fillOval((int) (x + width * 0.46), (int) (y - width * 0.05), (int) (width * 0.4), (int) (width * 0.4));
        graphics.fillOval((int) (x + width * 0.75), (int) (y + width * 0.05), (int) ((width - (width * 0.75))), (int) ((width - (width * 0.75))));

        graphics.setColor(oldColor);
    }

    public void move(boolean toLeft) {
        if (toLeft) {
            this.x = x - 1;
            if (this.x == -350) {
                this.x = 1550;
            }
        } else {
            this.x = x + 1;
            if (this.x == 1550) {
                this.x = -350;
            }
        }
    }
}
