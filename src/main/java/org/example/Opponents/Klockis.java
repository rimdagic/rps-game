package org.example.Opponents;

import org.example.Move;

public class Klockis implements BehaviourInterface {

    @Override
    public Move chooseMove() {
        Long date = System.currentTimeMillis();

        long lastDigit = date % 10;
        int index;

        if( lastDigit < 4 ) {
            index = 0;
        } else if ( lastDigit > 6 ) {
            index = 1;
        } else {
            index = 2;
        }

        return Move.values()[index];
    }
}
