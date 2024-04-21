package org.score.theme.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardTest {
    ScoreBoard score;

    @BeforeEach
    void setUp() {
        var homeTeam = new Team("Brazil");
        var awayTeam = new Team("France");
        score = new ScoreBoard(homeTeam,awayTeam,2,3, false, 1);
    }

    @AfterEach
    void tearDown() {
        score = null;
    }

    @Test
    void testToString() {
        System.out.println(score);
        assertFalse(score.gameStatus);
        assertEquals(score.homeTeam.name, "Brazil");
    }
}