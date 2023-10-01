package org.example.Opponents;

import org.example.Move;

import java.util.Random;

public class Slumpis implements BehaviourInterface {

    private int score;
    private String name = "Slumpis";

    @Override
    public Move chooseMove() {
        System.out.println("Slumpis Move on random");
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