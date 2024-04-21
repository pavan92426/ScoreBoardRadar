package org.score.theme.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardTest {
    ScoreBoard score;

    @BeforeEach
    void setUp() {
        var team = new Team("Brazil",2);
        score = new ScoreBoard(team,false,1);
    }

    @AfterEach
    void tearDown() {
        score = null;
    }

    @Test
    void testToString() {
        System.out.println(score);
        System.out.println(score.team);
        assertFalse(score.gameStatus);
        assertEquals(score.team.name,"Brazil");
    }
}