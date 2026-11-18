package com.comp2042;

import javafx.scene.image.Image;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class Coin {
    private Point pos;
    private Image image = new Image("resources/views/res/redcoin.png");

    public Coin(int x, int y, Snake snek, Obstacle obstacle) {
        List<Point> available = GridPositionPicker.availablePositions(
                x, y, snek.getHead(), snek.getBody(), obstacle.getObstacles(), null);
        if (available.isEmpty()) {
            throw new IllegalStateException("No free grid cell is available for a coin.");
        }
        pos = available.get(new Random().nextInt(available.size()));
    }

    public Point getPos() {
        return new Point(pos);
    }

    public int getPoints() {
        int points = 5;
        return points;
    }

    public Image getImage() {
        return image;
    }
}
