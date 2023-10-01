package org.example;

import org.example.Menu.ChooseOpponent;
import org.example.Menu.Menu;
import org.example.Menu.PlayerName;
import org.example.Menu.StartGame;
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
    public Opponent opponent = new Opponent(new Slumpis());
    public List<GameResult> gameResultList = new ArrayList<>();

    List<RoundResult> currentRoundResultList = new ArrayList<>();

    public void start(Game game){
        System.out.println("Player : " + player.getName() + "\t Computer : " + opponent.getName());



        Menu menu = new Menu();
        menu.addMenuItem(new PlayerName(player));
        menu.addMenuItem(new ChooseOpponent(opponent, player));
        menu.addMenuItem(new StartGame(game));

        menu.run();

        System.out.println(player.getName());
        System.out.println(opponent.getName());

    }

    public void play(){

        System.out.println("Number of rounds: ");
        int initialNumberOfRounds = scanner.nextInt();
        int numberOfRoundsCount = initialNumberOfRounds;

        while(numberOfRoundsCount > 0){
            Move playerMove = player.chooseMove();
            Move opponentMove = opponent.behaviour.chooseMove();
            System.out.println(player.getName() + " : " + playerMove + "\t" + opponent.getName()+ " : " + opponentMove);

            System.out.println(decideWinner(playerMove, opponentMove));

            List<RoundResult> clonedRoundResultList = Utils.cloneList(currentRoundResultList);

            currentRoundResultList.add(
                    new RoundResult(
                            player.getName(),
                            playerMove,
                            opponent.getName(),
                            opponentMove,
                            decideWinner(playerMove, opponentMove)
                    ));

            currentRoundResultList.clear();

            numberOfRoundsCount--;
        }

    }

    private Result decideWinner(Move playerMove, Move opponentMove){
        if (playerMove == Move.ROCK){
            if (opponentMove == Move.PAPER){
                return Result.COMPUTER_WIN;
            } else if (opponentMove == Move.SCISSORS) {
                return Result.PLAYER_WIN;
            }
        } else if (playerMove == Move.PAPER) {
            if (opponentMove == Move.ROCK){
                return Result.PLAYER_WIN;
            } else if (opponentMove == Move.SCISSORS){
                return Result.COMPUTER_WIN;
            }
        } else if (playerMove == Move.SCISSORS) {
            if (opponentMove == Move.ROCK) {
                return Result.COMPUTER_WIN;
            } else if (opponentMove == Move.PAPER) {
                return Result.PLAYER_WIN;
            }
        }
        return Result.DRAW;
    }

    private void printResult(Result result){
        if(result == Result.PLAYER_WIN){
            System.out.println(player.getName() + " wins");
        }
    }
}
