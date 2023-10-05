package org.example.Results;

import java.util.List;

public class GameResult {
    private int numberOfRounds;
    private List<RoundResult> roundList;
    private Result gameResult;
    private int playerScore;
    private int opponentScore;
    private String opponentName;

    public GameResult(int numberOfRounds, List<RoundResult> roundList, Result gameResult, String opponentName, int playerScore, int opponentScore) {
        this.numberOfRounds = numberOfRounds;
        this.roundList = roundList;
        this.gameResult = gameResult;
        this.opponentName = opponentName;
        this.playerScore = playerScore;
        this.opponentScore = opponentScore;
    }

    @Override
    public String toString() {
        return "\n-----Game-----\n" +
                "Number of rounds: " + numberOfRounds +
                "\nRound details:\n" + roundList +
                "Game winner: \t" + gameResult + "\t" + "Your score: " + playerScore + "\t" + opponentName + " score: " + opponentScore + "\n" +
                "--------------\n";
    }

    public Result getGameResult() {
        return gameResult;
    }
    public String getOpponentName() {
        return opponentName;
    }

}
