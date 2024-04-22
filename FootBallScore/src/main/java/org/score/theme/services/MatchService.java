package org.score.theme.services;

import org.score.theme.Match;
import org.score.theme.models.ScoreBoard;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class MatchService implements Match {

    List<ScoreBoard> matches;

    public MatchService(List<ScoreBoard> matches) {
        this.matches = matches;
    }

    /**
     * A match started will be added to the live matches active list.
     *
     * @return match
     */
    @Override
    public List<ScoreBoard> startMatch(ScoreBoard match) {
        System.out.println("Entering start match:" + matches.size());
        if (match.isGameStatus()) {
            matches.add(match);
        }
        System.out.println("Exiting start match:" + matches.size());
        return matches;
    }

    /**
     * update match receives updates of ongoing match.
     * @param matchID, homeScore, awayScore
     * @return void
     */
    @Override
    public void updateMatch(int matchID, int homeScore, int awayScore) {
        System.out.println("Entering update match with size" + matches.size());
        var getMatch = matches.stream().filter(scoreBoard -> scoreBoard.getGameID() == matchID).findFirst();
        getMatch.ifPresentOrElse(scoreBoard -> {
            scoreBoard.setHomeScore(homeScore);
            scoreBoard.setAwayScore(awayScore);
        }, () -> {
            throw new NoSuchElementException("Not able to find a active match to update the score");
        });
        System.out.println("Exiting update match with size" + matches.size());
    }

    /**
     * finish match will remove the match from score board.
     * @param matchID, status
     * @return void
     */
    @Override
    public void finishMatch(int matchID, boolean status) {
        var getMatch = matches.stream().filter(scoreBoard -> scoreBoard.getGameID() == matchID).findFirst();
        getMatch.ifPresentOrElse(scoreBoard -> {
            scoreBoard.setGameStatus(status);
        }, () -> {
            throw new NoSuchElementException("Not able to find a active match to update the score");
        });
        matches.remove(getMatch.get());
    }

    /**
     * board summary keep changes based on same total scores.
     * @param matches
     * @return matches
     */
    @Override
    public List<ScoreBoard> boardSummary(List<ScoreBoard> matches) {
        System.out.println("Entering board summary");
        matches.sort(Comparator.comparingInt(ScoreBoard::getTotalScore)
                        .reversed()
                        .thenComparingInt(ScoreBoard::getGameID)
                //.reversed()
        );

        matches.forEach(val -> System.out.println(val.getHomeTeam() + "" + val.getHomeScore()
                + "-" + val.getAwayTeam() + "" + val.getAwayScore() + " - " + val.getGameID()));
        System.out.println("Exiting board summary");
        return matches;
    }
}
