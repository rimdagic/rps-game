package org.example.Menu;

import org.example.Results.GameResult;
import org.example.Results.Result;
import java.util.List;
import java.util.Scanner;

public class GameStatistics implements MenuItem {
    List<GameResult> gameResultList;
    Scanner scanner = new Scanner(System.in);
    public GameStatistics(List<GameResult> gameResultList) {
        this.gameResultList = gameResultList;
    }

    @Override
    public void execute() {
        System.out.println("1. Overall statistics");
        System.out.println("2. Result against Slumpis");
        System.out.println("3. Result against Klockis");
        System.out.println("4. Result against Namnis");
        int answer = scanner.nextInt();

        switch (answer){
            case 1:
                listAllGames();
                printOverallStatistics();
                break;

            case 2:
                printStatistics("Slumpis");
                break;

            case 3:
                printStatistics("Klockis");
                break;

            case 4:
                printStatistics("Namnis");
                break;
        }
    }

    @Override
    public String getDisplayChoice() {
        return "Game statistics";
    }

    private int getStatisticsAgainst(String opponentName, Result result){
        int statisticsAgainstOpponent = (int) gameResultList.stream()
                .filter(x -> x.getOpponentName().equals(opponentName))
                .filter(x -> x.getGameResult().equals(result))
                .count();
        return statisticsAgainstOpponent;
    }

    private int getWinningRate(String opponentName){
        double numberOfWins = (double) gameResultList.stream()
                .filter(x -> x.getOpponentName().equals(opponentName))
                .filter(x -> x.getGameResult().equals(Result.PLAYER_WIN))
                .count();

        double numberOfGames = (double) gameResultList.stream()
                .filter(x -> x.getOpponentName().equals(opponentName))
                .count();

        double winningPercentage = numberOfWins / numberOfGames * 100;
        return (int) Math.round(winningPercentage);
    }

    private void printStatistics(String opponentName){
        System.out.println("You have won: \t\t\t\t" + getStatisticsAgainst(opponentName, Result.PLAYER_WIN));
        System.out.println(opponentName + " has won: \t\t\t" + getStatisticsAgainst(opponentName, Result.COMPUTER_WIN));
        System.out.println("Games resulted in a draw: \t" + getStatisticsAgainst(opponentName, Result.DRAW));
        System.out.println("You have won " + getWinningRate(opponentName) + "% of the games");
    }

    private void printOverallStatistics(){
        int numberOfGames = gameResultList.size();
        int playerWins = (int) gameResultList.stream().filter(x -> x.getGameResult().equals(Result.PLAYER_WIN)).count();
        int computerWins = (int) gameResultList.stream().filter(x -> x.getGameResult().equals(Result.COMPUTER_WIN)).count();
        int numberOfDraws = (int) gameResultList.stream().filter(x -> x.getGameResult().equals(Result.DRAW)).count();

        double winningPercentage = (double) playerWins / (double) numberOfGames * 100;
        int winningPercentageInt = (int) Math.round(winningPercentage);

        System.out.println("You have won: \t\t\t\t" + playerWins);
        System.out.println("Computer has won: \t\t\t" + computerWins);
        System.out.println("Games resulted in a draw: \t" + numberOfDraws);
        System.out.println("You have won " + winningPercentageInt + "% of all the games");
    }


    private void listAllGames(){
        gameResultList.stream()
                .forEach(System.out::println);
    }

}
