package org.example.Menu;

import org.example.Opponents.Klockis;
import org.example.Opponents.Namnis;
import org.example.Opponents.Opponent;
import org.example.Opponents.Slumpis;
import org.example.Player;

import java.util.Scanner;

public class ChooseOpponent implements MenuItem {
    Opponent opponent;
    Player player;

    public ChooseOpponent(Opponent opponent, Player player) {
        this.opponent = opponent;
        this.player = player;
    }

    @Override
    public void execute() {
        System.out.println("Choose your opponent:");
        System.out.println("1. Slumpis \n2. Klockis\n3. Namnis");
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();

        switch (answer){
            case 1:
                opponent.setOpponent(new Slumpis(), "Slumpis");
                break;
            case 2:
                opponent.setOpponent(new Klockis(), "Klockis");
                break;
            case 3:
                opponent.setOpponent(new Namnis(player), "Namnis");
                break;
        }

    }

    @Override
    public String getDisplayChoice() {
        return "Choose your opponent";
    }

}
