package com.runcode.gadsleaderboard.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.runcode.gadsleaderboard.ui.LearningLeadersFragment;
import com.runcode.gadsleaderboard.ui.SkillIQLeadersFragment;

public class PagerAdapter extends FragmentPagerAdapter
{

    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 1:
                SkillIQLeadersFragment skillIQLeadersFragment = new SkillIQLeadersFragment();
                return skillIQLeadersFragment;
            default:
                LearningLeadersFragment tlf = new LearningLeadersFragment();
                return  tlf ;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0 :
                return "Learning Leaders";
            case 1 :
                return "Skill IQ Leaders";
        }
        return null ;
    }
}
