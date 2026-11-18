package com.comp2042;

import org.junit.jupiter.api.Test;

import java.awt.Point;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GridPositionPickerTest {
    @Test
    void returnsOnlyFreeCellsInsideTheBoard() {
        List<Point> available = GridPositionPicker.availablePositions(
                3, 2,
                new Point(0, 0),
                List.of(new Point(1, 0)),
                List.of(new Point(2, 1)),
                new Point(2, 0));

        assertEquals(List.of(new Point(0, 1), new Point(1, 1)), available);
    }

    @Test
    void returnsNoCellsWhenTheBoardIsFull() {
        List<Point> available = GridPositionPicker.availablePositions(
                2, 1,
                new Point(0, 0),
                List.of(new Point(1, 0)),
                List.of(),
                null);

        assertTrue(available.isEmpty());
    }

    @Test
    void rejectsNonPositiveBoardDimensions() {
        assertTrue(GridPositionPicker.availablePositions(0, 4, null, List.of(), List.of(), null).isEmpty());
        assertTrue(GridPositionPicker.availablePositions(4, -1, null, List.of(), List.of(), null).isEmpty());
    }
}
