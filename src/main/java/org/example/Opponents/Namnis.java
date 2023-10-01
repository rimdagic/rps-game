package org.example.Opponents;

import org.example.Move;
import org.example.Player;

import java.util.Random;

public class Namnis implements BehaviourInterface {

    Player player;
    private int score;
    private String name = "Namnis";

    public Namnis(Player player) {
        this.player = player;
    }

    @Override
    public Move chooseMove() {
        Random random = new Random();
        System.out.println(player.getName()+" FROM NAMINS CLASS");
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