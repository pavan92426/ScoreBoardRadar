package org.score.theme.services;

import org.junit.jupiter.api.*;
import org.score.theme.models.ScoreBoard;
import org.score.theme.models.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MatchServiceTest {
    private static List<ScoreBoard> matches;
    private static MatchService service;
    private static Team homeTeam;
    private static Team awayTeam;


    @BeforeAll
    public static void setUp() {
        matches = new ArrayList<ScoreBoard>();
        homeTeam = new Team("Norway");
        awayTeam = new Team("England");
        matches.add(new ScoreBoard(new Team("Uruguay"),new Team("Italy"),
                6,6,false,1));
        matches.add(new ScoreBoard(new Team("Spain"),new Team("Brazil"),
                10,2,false,2));
        matches.add(new ScoreBoard(new Team("Mexico"),new Team("Canada"),
                0,5,false,3));
        matches.add(new ScoreBoard(new Team("Argentina"),new Team("Australia"),
                3,1,false,4));
        matches.add(new ScoreBoard(new Team("Germany"),new Team("France"),
                2,2,false,5));
        matches.add( new ScoreBoard(homeTeam,awayTeam,0,0,true,7));
        service = new MatchService(matches);

    }

    @AfterAll
    public static void  tearDown() {
    }


    @Test
    void testStartMatch() {
        var match2 = new ScoreBoard(homeTeam,awayTeam,0,0,true,6);
        var matchData2 = service.startMatch(match2);
        assertNotNull(matchData2);
    }

    @Test
    void testUpdateMatch() {
        service.updateMatch(7,2,3);
        service.updateMatch(7,3,3);
        var match = service.matches.stream().filter(scoreBoard -> scoreBoard.getGameID() == 7).findFirst();
        assertEquals(match.get().getHomeScore(),3);
        assertEquals(match.get().getAwayScore(),3);
    }

    @Test
    void testUpdateMatch_NotFound() {
        Throwable exception = assertThrows(NoSuchElementException.class,() -> {
            service.updateMatch(-200,2,3);
        });
        assertEquals("Not able to find a active match to update the score", exception.getMessage());
    }

    @Test
    void testFinishMatch() {
        service.finishMatch(2,false);
        var matchRemoved = service.matches.stream().filter(scoreBoard -> scoreBoard.getGameID() == 2).findFirst();
        assertTrue(matchRemoved.isEmpty());
    }

    @Test
    void testBoardSummary() {
        var data = service.boardSummary(matches);
        assertNotNull(true);
    }
}