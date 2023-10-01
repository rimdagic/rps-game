package org.example.Results;

import org.example.Opponents.Opponent;
import java.util.List;

public class GameResult {
    private int numberOfRounds;
    private int playerScore;
    private int opponentScore;
    private List<RoundResult> roundList;
    private Result gameResult;

    private String opponentName;

    public GameResult(int numberOfRounds, List<RoundResult> roundList, Result gameResult, String opponentName) {
        this.numberOfRounds = numberOfRounds;
        this.roundList = roundList;
        this.gameResult = gameResult;
        this.opponentName = opponentName;
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "numberOfRounds=" + numberOfRounds +
                ", roundList=" + roundList +
                ", gameWinner=" + gameResult +
                '}';
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public List<RoundResult> getRoundList() {
        return roundList;
    }

    public Result getGameResult() {
        return gameResult;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getOpponentScore() {
        return opponentScore;
    }
}
