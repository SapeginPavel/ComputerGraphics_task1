package vsu.elements;

import java.awt.*;

public class Hill {
    private int x, y, width, height;

    public Hill(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics2D graphics) {
        Color oldColor = graphics.getColor();
        graphics.setColor(new Color(78, 203, 89));
        graphics.fillArc(x, y, width, height, 0, 180);
        graphics.setColor(new Color(0, 183, 74));
        graphics.drawArc(x, y, width + 1, height + 1, 0, 180);
        graphics.setColor(oldColor);
    }
}
