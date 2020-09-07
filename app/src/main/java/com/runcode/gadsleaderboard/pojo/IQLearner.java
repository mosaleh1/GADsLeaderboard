package com.runcode.gadsleaderboard.pojo;

import java.lang.reflect.GenericArrayType;

public class IQLearner extends Learner
{
    int score ;

    public IQLearner(String name, String country, String badgeUrl, int score) {
        super(name, country, badgeUrl);
        this.score = score;
    }

    public IQLearner() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
