package org.example.Opponents;

import org.example.Move;
import org.example.Player;
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

        List<String> someVowels = List.of(
                "A", "a",
                "U", "u",
                "I", "i"
        );

        List<String> otherVowels = List.of(
                "O", "o",
                "E", "e"
        );

        if(containsLetterFromList(someVowels) && index == 0){
            index = 2;
        } else if (containsLetterFromList(otherVowels) && index == 1) {
            index = 0;
        } else if (!containsLetterFromList(someVowels) && !containsLetterFromList(otherVowels) && index == 2) {
            index = 1;
        }

        return Move.values()[index];
    }

    private boolean containsLetterFromList(List<String> letters){
        boolean isContaining = false;
        for ( String letter : letters ) {
            if (player.getName().contains(letter)) {
                isContaining = true;
            }
        }
        return isContaining;
    }

}