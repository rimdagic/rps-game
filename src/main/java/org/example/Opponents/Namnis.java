package org.example.Opponents;

import org.example.Move;
import org.example.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Namnis implements BehaviourInterface {

    Player player;

    public Namnis(Player player) {
        this.player = player;
    }

    @Override
    public Move chooseMove() {
        Random random = new Random();
        int index = random.nextInt(Move.values().length);

        List<String> rockVowels = List.of(
                "A", "a",
                "U", "u",
                "I", "i"
        );

        for ( String letter : rockVowels ) {
            if (player.getName().contains(letter)) {
                index = 0;
                break;
            }
        }

        return Move.values()[index];
    }


}