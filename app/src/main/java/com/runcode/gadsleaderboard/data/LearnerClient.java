package com.runcode.gadsleaderboard.data;

import android.net.Uri;

import com.runcode.gadsleaderboard.pojo.IQLearner;
import com.runcode.gadsleaderboard.pojo.LearningHoursLearner;

import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LearnerClient  {
    public static final String BASE_URL = "https://gadsapi.herokuapp.com";


    LearnerItemInterface mLearnerItemInterface ;

    private static LearnerClient INSTANCE = null ;

        public LearnerClient ()
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mLearnerItemInterface = retrofit.create(LearnerItemInterface.class);

        }

    public static LearnerClient getINSTANCE() {
        if (INSTANCE == null)
        {
            INSTANCE = new LearnerClient();
        }
        return INSTANCE ;
    }

    public Call<List<IQLearner>> getAllLearnersIQ (){
            return mLearnerItemInterface.getAllSkillIQLeaner();
    }


    public Call<List<LearningHoursLearner>> getAllHoursLearners (){
        return mLearnerItemInterface.getAllHoursLearners();
    }

}
