package org.example.Opponents;

import org.example.Move;

public class Opponent {
    private String name;
    private int score;
    private BehaviourInterface behaviour;

    public Opponent(String name, BehaviourInterface behaviour) {
        this.name = name;
        this.behaviour = behaviour;
    }

    public void setOpponent(BehaviourInterface behaviour, String name){
        this.behaviour = behaviour;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getScore() {
        return score;
    }

    public void clearScore(){
        score = 0;
    }

    public void addScore(){
        score++;
    }

    public Move chooseMove(){
        return behaviour.chooseMove();
    }

}
