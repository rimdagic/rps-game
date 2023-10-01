package org.example.Menu;

import org.example.Game;
import org.example.Move;
import org.example.Opponents.Opponent;
import org.example.Player;

import java.util.List;
import java.util.Scanner;

public class StartGame implements MenuItem{
    private Game game;

    Scanner scanner = new Scanner(System.in);

    public StartGame(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        if (game.player.getName() == null) {
            System.out.println("Please enter player name first");
        } else{
            game.play();
        }
    }

    @Override
    public String getDisplayChoice() {
        return "Start game";
    }

}
