package org.score.theme.models;

public class ScoreBoard {
    Team team;
    boolean gameStatus;
    int gameID;

    public ScoreBoard(Team team, boolean gameStatus, int gameID) {
        this.team = team;
        this.gameStatus = gameStatus;
        this.gameID = gameID;
    }

    @Override
    public String toString() {
        return "ScoreBoard{" +
                "team Name=" + team.name + "team Score=" + team.score +
                ", gameStatus=" + gameStatus +
                ", gameID=" + gameID +
                '}';
    }
}
