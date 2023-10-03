package org.example;

import org.example.Opponents.Slumpis;

public class Main {
    public static void main(String[] args) {

        Logo.print();
        Game game = new Game();
        game.start(game);
    }
}