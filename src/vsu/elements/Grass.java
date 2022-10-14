package vsu.elements;

import java.awt.*;

public class Grass {
    private int x, y, size;

    public Grass(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void draw(Graphics2D graphics) {
        Color oldColor = graphics.getColor();
        graphics.setColor(new Color(37, 146, 56)); //переделать
        for (int i = -5; i < 5; i++) {
            graphics.drawLine(x, y, x + i * (int) (0.15 * size), y - size);
        }
        graphics.setColor(oldColor);
    }
}
