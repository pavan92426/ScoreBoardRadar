package org.score.theme.models;

public class ScoreBoard {
    Team homeTeam, awayTeam;
    int homeScore, awayScore;
    boolean gameStatus;
    int gameID;

    public ScoreBoard(Team homeTeam, Team awayTeam, int homeScore, int awayScore, boolean gameStatus, int gameID) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.gameStatus = gameStatus;
        this.gameID = gameID;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public int getGameID() {
        return gameID;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public boolean isGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(boolean gameStatus) {
        this.gameStatus = gameStatus;
    }

    @Override
    public String toString() {
        return "ScoreBoard{" +
                "homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                ", homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                ", gameStatus=" + gameStatus +
                ", gameID=" + gameID +
                '}';
    }
}
