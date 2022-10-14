package vsu.elements;

import java.awt.*;

public class Sun {
    private int x, y, d, x0, y0, radius;
    private static final int RAD = 1850;
    private static final int CENTER = 700;


    public Sun(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
        radius = RAD;
        x0 = CENTER;
        y0 = findCenterOfRotation(x, y, radius, CENTER);
    }

    public Sun(int x, int y, int d, int x0, int radius) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.x0 = x0;
        this.radius = radius;
        y0 = findCenterOfRotation(x, y, radius, x0);
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getD() {
        return d;
    }

    public void draw(Graphics2D graphics) {
        Color oldColor = graphics.getColor();
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(x, y, d, d);
        graphics.setColor(oldColor);
    }

    public void changeCoordinates(int dx) {
        this.setX(this.getX() + dx);
        this.setY(y0 - (int) Math.sqrt(Math.pow(radius, 2) - Math.pow((x0 - this.getX()), 2)));
    }

    private int findCenterOfRotation(int x, int y, int radius, int xOfCent) { //в норм проекте отдельно можно считать квадратные уравнения
        int discriminant = 4 * y * y - 4 * ((- radius * radius + (x - xOfCent) * (x - xOfCent)) + y * y);
        int y1 = (int) (2 * y - Math.sqrt(discriminant)) / 2;
        int y2 = (int) (2 * y + Math.sqrt(discriminant)) / 2;
        return y1 > 0 ? y1 : y2;
    }

    public boolean sunRises() {
        return y < 330;
    }

    public boolean sunIsSetting() {
        return y > 330;
    }
}
