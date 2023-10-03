package org.example.Opponents;

import org.example.Move;

public class Opponent {

    private String name = "Namn";
    private int score;

    public BehaviourInterface behaviour;
    public Opponent(BehaviourInterface behaviour) {
        this.behaviour = behaviour;
    }

    public Opponent(String name, BehaviourInterface behaviour) {
        this.name = name;
        this.behaviour = behaviour;
    }

    public void setOpponent(BehaviourInterface behaviour, String name){
        this.behaviour = behaviour;
        this.name = name;
    }

    public void setName(String name) {
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
