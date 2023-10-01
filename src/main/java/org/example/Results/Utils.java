package org.example.Results;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<RoundResult> cloneList(List<RoundResult> inputList){
        List<RoundResult> clonedList = new ArrayList<>();

        for (RoundResult instance : inputList){
            RoundResult clonedInstance = instance;
            clonedList.add(clonedInstance);
        }
        return clonedList;
    }

    public static int getPlayerWins(List<GameResult> gameResultList){
        int numberOfWins = (int) gameResultList.stream()
                .filter(x -> x.getGameResult().equals(Result.PLAYER_WIN))
                .count();
        return numberOfWins;
    }

    public static int getNumberOfGames(List<GameResult> gameResultList){
        int numberOfGames = (int) gameResultList.stream()
                .count();
        return numberOfGames;
    }

    public static int getComputerWins(List<GameResult> gameResultList){
        int numberOfComputerWins = (int) gameResultList.stream()
                .filter(x -> x.getGameResult().equals(Result.COMPUTER_WIN))
                .count();
        return numberOfComputerWins;
    }

    public static int getNumberOfDraws(List<GameResult> gameResultList){
        int numberOfDraws = (int) gameResultList.stream()
                .filter(x -> x.getGameResult().equals(Result.DRAW))
                .count();
        return numberOfDraws;
    }

}
