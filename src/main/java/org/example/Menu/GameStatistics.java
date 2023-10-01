package org.example.Menu;

import org.example.Opponents.Opponent;
import org.example.Results.GameResult;
import org.example.Results.Utils;

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

        int playerWins = Utils.getPlayerWins(gameResultList);

        switch (answer){
            case 1:
                int numberOfGames = Utils.getNumberOfGames(gameResultList);
                int numberOfComputerWins = Utils.getComputerWins(gameResultList);
                int numberOfDraws = Utils.getNumberOfDraws(gameResultList);
                double winningpercentage = (double) playerWins / (double) numberOfGames * 100;

                System.out.println("Human won games: \t\t" + playerWins + "\n" +
                        "Computer won games: \t" + numberOfComputerWins + "\n" +
                        "Draws: \t\t\t\t\t" + numberOfDraws);
                System.out.println("Human winning rate: \t" + winningpercentage + " %");
                break;
            case 2:
                break;
        }
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
