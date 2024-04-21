package org.score.theme.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {
    Team team;

    @BeforeEach
    void setUp() {
        team = new Team("Argentina",5);
    }

    @AfterEach
    void tearDown() {
        team = null;
    }

    @Test
    void testToString() {
        System.out.println(team);
        Assertions.assertEquals(team.name,"Argentina");
        Assertions.assertEquals(team.score,5);
    }
}