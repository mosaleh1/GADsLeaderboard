package com.runcode.gadsleaderboard.data;

import com.runcode.gadsleaderboard.pojo.IQLearner;
import com.runcode.gadsleaderboard.pojo.LearningHoursLearner;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearnerItemInterface {
    @GET("api/hours")
    public Call<List<LearningHoursLearner>> getAllHoursLearners ();
    @GET("api/skilliq")
    public Call<List<IQLearner>> getAllSkillIQLeaner ();

}
