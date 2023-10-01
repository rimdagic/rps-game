package org.example.Menu;

import org.example.Opponents.Opponent;
import org.example.Results.GameResult;
import java.util.List;
import java.util.Scanner;

public class GameStatistics implements MenuItem{

    List<GameResult> gameResultList;
    Scanner scanner = new Scanner(System.in);
    public GameStatistics(List<GameResult> gameResultList) {
        this.gameResultList = gameResultList;
    }

    @Override
    public void execute() {
        System.out.println("1. Total wins");
        int answer = scanner.nextInt();


    }

    @Override
    public String getDisplayChoice() {
        return "Game statistics";
    }





    private List<GameResult> getStatistics(Opponent opponent) {
        List<GameResult> opponentList = gameResultList.stream()
                //.filter(x -> x.getOpponentName().equals(opponent))
                .toList();

        System.out.println(opponentList);
        return opponentList;
    }

}
