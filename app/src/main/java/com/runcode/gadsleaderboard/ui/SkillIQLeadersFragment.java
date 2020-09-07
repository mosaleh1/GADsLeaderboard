package com.runcode.gadsleaderboard.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.runcode.gadsleaderboard.R;
import com.runcode.gadsleaderboard.adapters.LearnersIQAdapter;
import com.runcode.gadsleaderboard.pojo.IQLearner;
import com.runcode.gadsleaderboard.ui.ViewModels.LearningIQFragmentViewModel;

import java.util.List;

public class SkillIQLeadersFragment extends Fragment {


    Context mContext ;
    LearningIQFragmentViewModel mViewModel ;
    private LearnersIQAdapter mAdapter;
    private RecyclerView mListOfLearner;
    private ProgressBar mProgressBar ;

    public SkillIQLeadersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_skill_iq_learning_leader, container, false);
        mListOfLearner = view.findViewById(R.id.list_IQ_learner);
        mProgressBar = view.findViewById(R.id.learnerIQ_bar);
        mAdapter = new LearnersIQAdapter();
        mListOfLearner.setLayoutManager(new LinearLayoutManager(mContext));
        mListOfLearner.setAdapter(mAdapter);
        return view ;
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel  = new ViewModelProvider(this).get(LearningIQFragmentViewModel.class);
        mViewModel.getLeadersIq();
        mViewModel.mIQListMutableLiveData.observe(this, new Observer<List<IQLearner>>() {
            @Override
            public void onChanged(List<IQLearner> iqLearners) {
                mProgressBar.setVisibility(View.GONE);
                mAdapter.setItems(iqLearners);

            }
        });
    }
}