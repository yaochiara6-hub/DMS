package com.comp2042;

import javafx.scene.input.KeyCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameRulesTest {
    @Test
    void reversalsAreBlockedAndContinuingOrTurningIsAllowed() {
        assertFalse(GameController.isValidDirection(KeyCode.DOWN, KeyCode.UP));
        assertFalse(GameController.isValidDirection(KeyCode.UP, KeyCode.DOWN));
        assertFalse(GameController.isValidDirection(KeyCode.LEFT, KeyCode.RIGHT));
        assertFalse(GameController.isValidDirection(KeyCode.RIGHT, KeyCode.LEFT));
        assertTrue(GameController.isValidDirection(KeyCode.DOWN, KeyCode.DOWN));
        assertTrue(GameController.isValidDirection(KeyCode.DOWN, KeyCode.LEFT));
        assertFalse(GameController.isValidDirection(KeyCode.LEFT, KeyCode.A));
    }

    @Test
    void everyPowerUpHasItsOwnReachableRoll() {
        assertEquals(GameController.PowerUpKind.GOLD, GameController.powerUpForRoll(1, true));
        assertEquals(GameController.PowerUpKind.RAINBOW, GameController.powerUpForRoll(2, true));
        assertEquals(GameController.PowerUpKind.BLUE, GameController.powerUpForRoll(3, true));
        assertEquals(GameController.PowerUpKind.SILVER, GameController.powerUpForRoll(4, true));
        assertEquals(GameController.PowerUpKind.NORMAL, GameController.powerUpForRoll(4, false));
    }

    @Test
    void obstacleCellsAreRemovedFromTheMaximumScore() {
        Game game = new Game(4, 3, false, 'N');
        game.decMaxScore(3);

        for (int i = 0; i < 6; i++) {
            game.incScore();
        }
        assertFalse(game.gameWon());
        game.incScore();
        assertTrue(game.gameWon());
    }
}
