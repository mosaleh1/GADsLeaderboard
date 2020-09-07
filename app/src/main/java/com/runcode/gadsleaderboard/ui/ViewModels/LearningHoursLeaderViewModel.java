package com.runcode.gadsleaderboard.ui.ViewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.runcode.gadsleaderboard.data.DataManager;
import com.runcode.gadsleaderboard.data.LearnerClient;
import com.runcode.gadsleaderboard.pojo.LearningHoursLearner;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningHoursLeaderViewModel extends ViewModel {
    public MutableLiveData<List<LearningHoursLearner>> mLearningHours = new androidx.lifecycle.MutableLiveData<>() ;

    public void getAllHoursTopLearner()
    {
        DataManager.getAllHoursLearners().enqueue(new Callback<List<LearningHoursLearner>>() {
            @Override
            public void onResponse(Call<List<LearningHoursLearner>> call, Response<List<LearningHoursLearner>> response) {
                mLearningHours.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<LearningHoursLearner>> call, Throwable t) {

            }
        });
    }
}
