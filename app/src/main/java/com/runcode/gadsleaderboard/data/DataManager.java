package com.runcode.gadsleaderboard.data;

import com.runcode.gadsleaderboard.pojo.IQLearner;
import com.runcode.gadsleaderboard.pojo.LearningHoursLearner;

import java.util.List;

import retrofit2.Call;

public class DataManager
{

    static LearnerClient mClient ;

    static
    {
        mClient = LearnerClient.getINSTANCE();
    }

    public static Call<List<IQLearner>> getAllLearnersIQ (){
        return mClient.getAllLearnersIQ();
    }

    public static Call<List<LearningHoursLearner>> getAllHoursLearners (){
        return mClient.getAllHoursLearners();
    }
}
