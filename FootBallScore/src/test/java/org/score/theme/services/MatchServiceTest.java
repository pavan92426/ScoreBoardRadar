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
    private static List<ScoreBoard> activeMatches;
    private static MatchService service;
    private static Team homeTeam;
    private static Team awayTeam;


    @BeforeAll
    public static void setUp() {
        activeMatches = new ArrayList<ScoreBoard>();
        matches = new ArrayList<ScoreBoard>();
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
        service = new MatchService(matches);

        homeTeam = new Team("Norway");
        awayTeam = new Team("England");
    }

    @AfterAll
    public static void  tearDown() {
    }


    @Test
    void testStartMatch() {
        var match1 = new ScoreBoard(homeTeam,awayTeam,0,0,true,7);
        var matchData1 = service.startMatch(match1);
        var match2 = new ScoreBoard(homeTeam,awayTeam,0,0,true,6);
        var matchData2 = service.startMatch(match2);
        assertNotNull(matchData1);
        assertNotNull(matchData2);
    }

    @Test
    void updateMatch() {
        activeMatches.add(new ScoreBoard(homeTeam,awayTeam,0,0,true,8));
        service.activeMatches = activeMatches;
        service.updateMatch(8,2,3);
        service.updateMatch(8,3,3);
        var match = service.activeMatches.stream().filter(scoreBoard -> scoreBoard.getGameID() == 8).findFirst();
        assertEquals(match.get().getHomeScore(),3);
        assertEquals(match.get().getAwayScore(),3);
    }

    @Test
    void updateMatch_NotFound() {
        Throwable exception = assertThrows(NoSuchElementException.class,() -> {
            service.updateMatch(-200,2,3);
        });
        assertEquals("Not able to find a active match to update the score", exception.getMessage());
    }

    @Test
    void finishMatch() {
        var match1 = activeMatches.add(new ScoreBoard(homeTeam,awayTeam,5,5,true,9));
        service.finishMatch(9,false);
        var matchRemoved = service.activeMatches.stream().filter(scoreBoard -> scoreBoard.getGameID() == 9).findFirst();
        assertTrue(matchRemoved.isEmpty());
        var matchAdded = service.matches.stream().filter(scoreBoard -> scoreBoard.getGameID() == 9).findFirst();
        assertNotNull(matchAdded);
    }

    @Test
    void testBoardSummary() {
    }
}