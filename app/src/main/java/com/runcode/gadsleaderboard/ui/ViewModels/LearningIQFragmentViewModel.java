package com.runcode.gadsleaderboard.ui.ViewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.runcode.gadsleaderboard.data.DataManager;
import com.runcode.gadsleaderboard.data.LearnerClient;
import com.runcode.gadsleaderboard.pojo.IQLearner;
import com.runcode.gadsleaderboard.pojo.LearningHoursLearner;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningIQFragmentViewModel extends ViewModel
{
    public MutableLiveData<List<IQLearner>> mIQListMutableLiveData = new MutableLiveData<>() ;

    public void getLeadersIq(){
        DataManager.getAllLearnersIQ().enqueue(new Callback<List<IQLearner>>() {
            @Override
            public void onResponse(Call<List<IQLearner>> call, Response<List<IQLearner>> response) {
                mIQListMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<IQLearner>> call, Throwable t) {

            }
        });

    }
}
