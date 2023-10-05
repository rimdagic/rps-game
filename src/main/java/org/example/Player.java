package org.example;

import java.util.Scanner;

public class Player {
    private String name;
    private int score;

    public Move chooseMove() {
        System.out.println("Choose your move (1. ROCK, 2. PAPER, 3. SCISSORS)");
        Scanner scanner = new Scanner(System.in);
        int playerChoice = scanner.nextInt();
        Move playerMove = Move.values()[playerChoice -1];
        return playerMove;
    }

    public int getScore() {
        return score;
    }

    public int addScore() {
        score++;
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void clearScore(){
        score = 0;
    }

}
