package org.score.theme.services;

import org.score.theme.Match;
import org.score.theme.models.ScoreBoard;

import java.util.List;

public class MatchService implements Match {

    List<ScoreBoard> matches;

    public MatchService(List<ScoreBoard> matches) {
        this.matches = matches;
    }

    @Override
    public List<ScoreBoard> startMatch(ScoreBoard match) {
        System.out.println("Entering start match:"+matches.size());
        matches.add(match);
        System.out.println("Exiting start match:"+matches.size());
        return matches;
    }

    @Override
    public void updateMatch(int matchID, int homeScore, int awayScore) {
        System.out.println("Entering update match with size"+matches.size());
        var getMatch = matches.stream().filter(scoreBoard -> scoreBoard.getGameID() == matchID).findFirst();
        getMatch.ifPresent(scoreBoard -> {
            scoreBoard.setHomeScore(homeScore);
            scoreBoard.setAwayScore(awayScore);
        });
        System.out.println("Exiting update match with size"+matches.size());
    }

    @Override
    public ScoreBoard finishMatch(int matchID,boolean status) {
        return null;
    }


    @Override
    public List<ScoreBoard> boardSummary(List<ScoreBoard> matches) {
        return matches;
    }
}
