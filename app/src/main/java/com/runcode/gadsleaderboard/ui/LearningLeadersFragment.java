package com.runcode.gadsleaderboard.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.runcode.gadsleaderboard.R;
import com.runcode.gadsleaderboard.adapters.LearnerLeaderAdapter;
import com.runcode.gadsleaderboard.adapters.PagerAdapter;
import com.runcode.gadsleaderboard.pojo.LearningHoursLearner;
import com.runcode.gadsleaderboard.ui.ViewModels.LearningHoursLeaderViewModel;
import com.runcode.gadsleaderboard.ui.ViewModels.LearningIQFragmentViewModel;

import java.util.List;


public class LearningLeadersFragment extends Fragment {

    private Context mContext ;
    ProgressBar mProgressBar;
    LearningHoursLeaderViewModel mViewModel ;
    public LearningLeadersFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_learning_leaders, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mContext = getContext();
        mViewModel  = new ViewModelProvider(this).get(LearningHoursLeaderViewModel.class);
        mViewModel.getAllHoursTopLearner();
        RecyclerView learningHoursLeadersRecyclerView = view.findViewById(R.id.list_learningLeaders);
        mProgressBar = view.findViewById(R.id.learnerHour_bar);
        learningHoursLeadersRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        LearnerLeaderAdapter adapter = new LearnerLeaderAdapter();
        learningHoursLeadersRecyclerView.setAdapter(adapter);
        mViewModel.mLearningHours.observe(getViewLifecycleOwner(), new Observer<List<LearningHoursLearner>>() {
            @Override
            public void onChanged(List<LearningHoursLearner> learningHoursLearners) {
                mProgressBar.setVisibility(View.GONE);
                adapter.setItems(learningHoursLearners);
            }
        });
    }
}