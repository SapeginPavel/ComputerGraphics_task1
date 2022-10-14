package vsu;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Window extends JFrame {
    private final PicturePanel pp;

    public Window() throws HeadlessException {
        pp = new PicturePanel();
        this.add(pp);
    }
}
