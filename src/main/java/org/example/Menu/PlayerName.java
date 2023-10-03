package org.example.Menu;
import org.example.Player;

import java.util.Scanner;

public class PlayerName implements MenuItem {

    private String name = "Player name";
    private Player player;

    public PlayerName(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        System.out.println("Enter player name: ");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        player.setName(name);
        System.out.println("Player namne successfully updated : " + name);
    }

    @Override
    public String getDisplayChoice() {
        return "Player name";
    }
}
