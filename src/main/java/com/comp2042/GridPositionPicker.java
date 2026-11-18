package com.comp2042;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/** Finds unoccupied cells on the game's rectangular grid. */
final class GridPositionPicker {
    private GridPositionPicker() {
    }

    /**
     * Returns every in-bounds cell that is not occupied by the snake, an obstacle, or a coin.
     */
    static List<Point> availablePositions(int width, int height, Point head,
                                          List<Point> body, List<Point> obstacles, Point coin) {
        List<Point> available = new ArrayList<>();
        if (width <= 0 || height <= 0) {
            return available;
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Point candidate = new Point(x, y);
                if (!candidate.equals(head)
                        && !body.contains(candidate)
                        && !obstacles.contains(candidate)
                        && !candidate.equals(coin)) {
                    available.add(candidate);
                }
            }
        }
        return available;
    }
}
