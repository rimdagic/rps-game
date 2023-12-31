package org.example.Menu;

import org.example.Game;

public class StartGame implements MenuItem {
    private Game game;

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
