package org.score.theme.services;

import org.score.theme.Match;
import org.score.theme.models.ScoreBoard;

import java.util.List;
import java.util.NoSuchElementException;

public class MatchService implements Match {

    List<ScoreBoard> matches;
    List<ScoreBoard> activeMatches;

    public MatchService(List<ScoreBoard> matches) {
        this.matches = matches;
    }

    @Override
    public List<ScoreBoard> startMatch(ScoreBoard match) {
        System.out.println("Entering start match:"+activeMatches.size());
        if (match.isGameStatus()) {
            activeMatches.add(match);
        }
        System.out.println("Exiting start match:"+activeMatches.size());
        return activeMatches;
    }

    @Override
    public void updateMatch(int matchID, int homeScore, int awayScore) {
        System.out.println("Entering update match with size"+activeMatches.size());
        var getMatch = activeMatches.stream().filter(scoreBoard -> scoreBoard.getGameID() == matchID).findFirst();
        getMatch.ifPresentOrElse(scoreBoard -> {
            scoreBoard.setHomeScore(homeScore);
            scoreBoard.setAwayScore(awayScore);
        }, () -> {
            throw new NoSuchElementException("Not able to find a active match to update the score");
        });
        System.out.println("Exiting update match with size"+activeMatches.size());
    }

    @Override
    public void finishMatch(int matchID,boolean status) {
        var getMatch = activeMatches.stream().filter(scoreBoard -> scoreBoard.getGameID() == matchID).findFirst();
        getMatch.ifPresentOrElse(scoreBoard -> {
            scoreBoard.setGameStatus(status);
        }, () -> {
            throw new NoSuchElementException("Not able to find a active match to update the score");
        });
        matches.add(getMatch.get());
        activeMatches.remove(getMatch.get());
    }


    @Override
    public List<ScoreBoard> boardSummary(List<ScoreBoard> matches) {
        return matches;
    }
}
