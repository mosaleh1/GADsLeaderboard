package com.runcode.gadsleaderboard.pojo;

public class LearningHoursLearner extends Learner{
    private int hours ;

    public LearningHoursLearner()
    {}

    public LearningHoursLearner(String name , String  country , String badgeUrl, int hours)
    {
        super(name,country,badgeUrl);
        this.hours = hours ;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
