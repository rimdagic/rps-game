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
                opponent.setBehaviour(new Slumpis());
                break;
            case 2:
                opponent.setBehaviour(new Klockis());
                break;
            case 3:
                opponent.setBehaviour(new Namnis(player));
                break;
        }

    }

    @Override
    public String getDisplayChoice() {
        return "Choose your opponent";
    }
}
