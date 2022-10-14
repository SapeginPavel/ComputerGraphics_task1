package vsu.elements;

import java.awt.*;

public class Night {

    private int opacity = 255;

    public void draw(Graphics2D graphics) {
        Color oldColor = graphics.getColor();
        graphics.setColor(new Color(0, 0, 0, opacity));
        graphics.fillRect(0, 0, 2000, 2000);
        graphics.setColor(oldColor);
    }

    public boolean isLight() {
        return opacity == 0;
    }

    public boolean isNight() {
        return opacity == 255;
    }

    public void dawn(int dTransparency) {
        opacity -= dTransparency;
    }
}
