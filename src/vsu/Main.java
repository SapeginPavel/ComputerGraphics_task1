package vsu;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
	    Window window = new Window();
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window.setExtendedState(Frame.MAXIMIZED_BOTH);
        window.setVisible(true);
    }
}
