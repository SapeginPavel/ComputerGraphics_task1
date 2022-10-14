package vsu.elements;

import java.awt.*;

public class Bird {
    private int x, y, width, height;

    public Bird(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
        height = width / 3;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void draw(Graphics2D graphics) {
        Color oldColor = graphics.getColor();
        graphics.setColor(Color.BLACK);
        graphics.drawArc(x, y, width / 2, height, 10, 100); //левое крыло
        graphics.drawArc(x + width / 2, y, width / 2, height, 170, -100); //правое крыло
        graphics.setColor(oldColor);
    }
}
