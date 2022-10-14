package vsu;

import vsu.elements.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

public class PicturePanel extends JPanel {

    private Sun sun;
    private Night night;
    private Cloud[] clouds;
    private Hill[] hills;
    private Spruce[] spruces;
    private Ship ship;
    private Bird[] birds;
    private Grass[] grasses;

    public MyTimerTask pictureMovies = new MyTimerTask();
    private Timer timer = new Timer();

    private boolean isRun = false;

    class MyTimerTask extends TimerTask {
        public int speed = 0;
        @Override
        public void run() {
            if (speed % 32 == 0) {
                sun.changeCoordinates(1);
            }
                if (speed % 20 == 0) {
                    for (int j = 0; j < clouds.length; j++) {
                        clouds[j].move(false);
                    }
                }
                if (speed % 20 == 0) {
                    if (!night.isLight() && sun.sunRises()) {
                        night.dawn(1);
                    } else if (!night.isNight() && sun.sunIsSetting()) {
                        night.dawn(-1);
                    }
                }
                if (speed % 64 == 0) {
                    ship.move(900, 1500);
                }
                speed += 4;
                repaint();
        }
    }

    public PicturePanel() {
        sun = new Sun(-150, 300, 90); //-150
        night = new Night();

        clouds = new Cloud[]{
                new Cloud(500, 40, 150),
                new Cloud(800, 85, 90),
                new Cloud(1000, 160, 230),
                new Cloud(210, 110, 50),
                new Cloud(80, 90, 90),
                new Cloud(1400, 240, 100),
                new Cloud(1150, 270, 100),
                new Cloud(350, 160, 110),
                new Cloud(1540, 90, 100),
                new Cloud(1700, 200, 220),
                new Cloud(1300, 20, 110),
                new Cloud(1990, 170, 180)};

        hills = new Hill[]{
                new Hill(-100, 300, 600, 200),
                new Hill(10, 420, 600, 200),
                new Hill(-200, 442, 1354, 900)
        };

        spruces = new Spruce[]{
                new Spruce(400, 500, 400),
                new Spruce(100, 300, 95),
                new Spruce(140, 310, 95),
                new Spruce(190, 320, 90),
                new Spruce(60, 350, 60),
                new Spruce(20, 370, 80),
                new Spruce(170, 760, 480),
                new Spruce(600, 590, 420)
        };

        birds = new Bird[]{
                new Bird(1300, 80, 100),
                new Bird(1200, 60, 95),
                new Bird(1280, 50, 80),
                new Bird(1220, 30, 50),
                new Bird(1050, 140, 110)
        };

        grasses = new Grass[]{
                new Grass(15, 760, 17),
                new Grass(50, 630, 20),
                new Grass(100, 700, 19),
                new Grass(250, 790, 20),
                new Grass(270, 570, 24),
                new Grass(300, 670, 22),
                new Grass(350, 690, 21),
                new Grass(400, 770, 17),
                new Grass(430, 650, 23),
                new Grass(480, 690, 17),
                new Grass(500, 550, 21),
                new Grass(540, 700, 21),
                new Grass(660, 750, 17),
                new Grass(710, 520, 17),
                new Grass(790, 680, 21),
                new Grass(830, 600, 20),
                new Grass(880, 660, 21),
                new Grass(950, 760, 30)
        };

        ship = new Ship(1050, 450, 300);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!isRun) {
                    pictureMovies.run();
                    timer.scheduleAtFixedRate(pictureMovies, 0, 3);
                    isRun = true;
                } else {
                    pictureMovies.cancel();
                    System.exit(0);
                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics = (Graphics2D) g;

        graphics.setColor(new Color(99, 173, 208));
        graphics.fillRect(0, 0, 2000, 2000);

        sun.draw(graphics);

        for (Cloud cloud : clouds) {
            cloud.draw(graphics);
        }

        graphics.setColor(new Color(72, 41, 240));
        graphics.fillRect(0, graphics.getClipBounds().height - 440, 2000, 2000);

        for (Hill hill : hills) {
            hill.draw(graphics);
        }

        for (Spruce spruce : spruces) {
            spruce.draw(graphics);
        }

        for (Bird bird : birds) {
            bird.draw(graphics);
        }

        ship.draw(graphics);

        for (Grass grass : grasses) {
            grass.draw(graphics);
        }

        night.draw(graphics);
    }
}
