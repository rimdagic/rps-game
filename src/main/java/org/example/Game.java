package org.example;

import org.example.Menu.*;
import org.example.Opponents.Opponent;
import org.example.Opponents.Slumpis;
import org.example.Results.GameResult;
import org.example.Results.Result;
import org.example.Results.RoundResult;
import org.example.Results.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    public Player player = new Player();
    public Opponent opponent = new Opponent("Slumpis", new Slumpis());
    public List<GameResult> gameResultList = new ArrayList<>();
    List<RoundResult> currentRoundResultList = new ArrayList<>();

    public void start(){
        Menu menu = new Menu();
        menu.addMenuItem(new PlayerName(player));
        menu.addMenuItem(new ChooseOpponent(opponent, player));
        menu.addMenuItem(new StartGame(this));
        menu.addMenuItem(new GameStatistics(gameResultList));

        menu.run();
    }

    public void play(){
        player.clearScore();
        opponent.clearScore();

        System.out.println("Number of rounds: ");
        int initialNumberOfRounds = scanner.nextInt();
        int numberOfRoundsCount = initialNumberOfRounds;

        while(numberOfRoundsCount > 0){
            Move playerMove = player.chooseMove();
            Move opponentMove = opponent.chooseMove();

            System.out.println(player.getName() + " : " + playerMove + "\t" + opponent.getName()+ " : " + opponentMove);

            currentRoundResultList.add(
                    new RoundResult(
                            player.getName(),
                            playerMove,
                            opponent.getName(),
                            opponentMove,
                            decideRoundWinner(playerMove, opponentMove)
                    ));

            numberOfRoundsCount--;
        }

        System.out.println("\n" + opponent.getName() + ": " + opponent.getScore());
        System.out.println(player.getName() + ": " + player.getScore() + "\n");

        Result gameWinner = decideGameWinner(player.getScore(), opponent.getScore());
        printResult(gameWinner);

        List<RoundResult> clonedRoundResultList = Utils.cloneList(currentRoundResultList);
        currentRoundResultList.clear();

        gameResultList.add(
                new GameResult(
                        initialNumberOfRounds,
                        clonedRoundResultList,
                        gameWinner,
                        opponent.getName(),
                        player.getScore(),
                        opponent.getScore()
                ));
    }



    private Result decideRoundWinner(Move playerMove, Move opponentMove){
        if (playerMove == Move.ROCK){
            if (opponentMove == Move.PAPER){
                opponent.addScore();
                System.out.println(opponent.getName() +" wins the round \n");
                return Result.COMPUTER_WIN;
            } else if (opponentMove == Move.SCISSORS) {
                player.addScore();
                System.out.println(player.getName() +" wins the round \n");
                return Result.PLAYER_WIN;
            }
        } else if (playerMove == Move.PAPER) {
            if (opponentMove == Move.ROCK){
                player.addScore();
                System.out.println(player.getName() +" wins the round \n");
                return Result.PLAYER_WIN;
            } else if (opponentMove == Move.SCISSORS){
                opponent.addScore();
                System.out.println(opponent.getName() +" wins the round \n");
                return Result.COMPUTER_WIN;
            }
        } else if (playerMove == Move.SCISSORS) {
            if (opponentMove == Move.ROCK) {
                opponent.addScore();
                System.out.println(opponent.getName() +" wins the round \n");
                return Result.COMPUTER_WIN;
            } else if (opponentMove == Move.PAPER) {
                player.addScore();
                System.out.println(player.getName() +" wins the round \n");
                return Result.PLAYER_WIN;
            }
        }
        System.out.println("This round is a draw!\n");
        return Result.DRAW;
    }

    private Result decideGameWinner(int playerScore, int opponentScore){
        int scoreOffset = playerScore - opponentScore;
        if(scoreOffset > 0){
            return Result.PLAYER_WIN;
        } else if (scoreOffset < 0 ) {
            return Result.COMPUTER_WIN;
        }
        return Result.DRAW;
    }

    private void printResult(Result result){
        if(result == Result.PLAYER_WIN){
            System.out.println(player.getName() + " wins the game!");
        } else if (result == Result.COMPUTER_WIN) {
            System.out.println(opponent.getName() + " wins the game!");
        } else{
            System.out.println("It's a draw!");
        }
        System.out.println("\n");
    }
}
