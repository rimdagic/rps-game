package org.example.Opponents;

import org.example.Move;
import java.util.Random;

public class Klockis implements BehaviourInterface {

    private int score;
    private String name = "Klockis";

    @Override
    public Move chooseMove() {
        Long date = System.currentTimeMillis();
        System.out.println("Millisecs : " + date);
        Random random = new Random();
        int index = random.nextInt(Move.values().length);
        return Move.values()[index];
    }

    @Override
    public void clearScore() {
        this.score = 0;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public int addScore() {
        score++;
        return score;
    }

    @Override
    public String getName() {
        return name;
    }
}
