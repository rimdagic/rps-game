package org.example.Opponents;

import org.example.Move;

public interface BehaviourInterface {
    public Move chooseMove();
    public void clearScore();
    public int getScore();
    public int addScore();
    public String getName();
}