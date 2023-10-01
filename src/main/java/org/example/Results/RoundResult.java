package org.example.Results;

import org.example.Move;

public class RoundResult {
    private String playerName;
    private Move playerMove;

    private String computerName;
    private Move computerMove;

    private Result roundResult;

    public RoundResult(String playerName, Move playerMove, String computerName, Move computerMove, Result roundResult) {
        this.playerName = playerName;
        this.playerMove = playerMove;

        this.computerName = computerName;
        this.computerMove = computerMove;

        this.roundResult = roundResult;
    }
}
