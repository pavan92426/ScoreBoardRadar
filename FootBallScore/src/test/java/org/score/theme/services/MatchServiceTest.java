package org.score.theme.services;

import org.junit.jupiter.api.*;
import org.score.theme.models.ScoreBoard;
import org.score.theme.models.Team;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatchServiceTest {
    private static List<ScoreBoard> matches;
    private static MatchService service;
    private static Team homeTeam;
    private static Team awayTeam;


    @BeforeAll
    public static void setUp() {
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
        var match = new ScoreBoard(homeTeam,awayTeam,0,0,true,6);
        //assertEquals(matches.size(),5);
        var matchData = service.startMatch(match);
        //service.matches = matchData;
        assertNotNull(matchData);
        assertEquals(matches.size(),7);
    }

    @Test
    void updateMatch() {
        matches.add(new ScoreBoard(homeTeam,awayTeam,0,0,true,6));
        service.updateMatch(6,2,3);
        service.updateMatch(6,3,3);
        var match = service.matches.stream().filter(scoreBoard -> scoreBoard.getGameID() == 6).findFirst();
        assertEquals(match.get().getHomeScore(),3);
        assertEquals(match.get().getAwayScore(),3);
    }

    @Test
    void finishMatch() {
    }

    @Test
    void testBoardSummary() {
    }
}