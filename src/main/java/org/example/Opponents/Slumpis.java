package org.example.Opponents;

import org.example.Move;

import java.util.Random;

public class Slumpis implements BehaviourInterface {

    @Override
    public Move chooseMove() {
        Random random = new Random();
        int index = random.nextInt(Move.values().length);
        return Move.values()[index];
    }

}
