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
}
