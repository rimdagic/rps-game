package org.example.Opponents;

public class Opponent {
    public BehaviourInterface behaviour;
    public Opponent(BehaviourInterface behaviour) {
        this.behaviour = behaviour;
    }

    public void setBehaviour(BehaviourInterface behaviour){
        this.behaviour = behaviour;
    }

    public String getName(){
        return behaviour.getName();
    }

    public int getScore() {
        return behaviour.getScore();
    }

    public void clearScore(){
        behaviour.clearScore();
    }

    public void addScore(){
        behaviour.addScore();
    }

}
