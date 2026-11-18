package com.comp2042;

import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Obstacle {
    private static final int MAX_OBSTACLES = 50;
    private Color color = Color.BLACK;
    private ArrayList<Point> obstacles = new ArrayList<>();
    private int x;
    private int y;

    public Obstacle(int x, int y) {
       this.x = x;
       this.y = y;
    }

    public void newObstacles(Snake snek, Coin coin, int amount) {
        int availableSlots = Math.max(0, MAX_OBSTACLES - obstacles.size());
        if (amount <= 0 || availableSlots == 0) {
            return;
        }

        List<Point> available = GridPositionPicker.availablePositions(
                x, y, snek.getHead(), snek.getBody(), obstacles, coin.getPos());
        Collections.shuffle(available, new Random());
        int placementCount = Math.min(amount, Math.min(availableSlots, available.size()));
        obstacles.addAll(available.subList(0, placementCount));
    }

    public Color getColor() {
        return color;
    }

    public ArrayList<Point> getObstacles() {
        return obstacles;
    }

    public void reset() {
        obstacles.clear();
    }
}
