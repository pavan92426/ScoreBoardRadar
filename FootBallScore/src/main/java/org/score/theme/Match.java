package org.score.theme;

import org.score.theme.models.ScoreBoard;

import java.util.List;

public interface Match {
    public List<ScoreBoard> startMatch(ScoreBoard match);

    public void updateMatch(int matchID,int homeScore, int AwayScore);

    public ScoreBoard finishMatch(int matchID,boolean status);

    public List<ScoreBoard> boardSummary(List<ScoreBoard> matches);
}
