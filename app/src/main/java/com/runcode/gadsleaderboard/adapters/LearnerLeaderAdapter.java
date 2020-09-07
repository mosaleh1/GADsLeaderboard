package com.runcode.gadsleaderboard.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.runcode.gadsleaderboard.R;
import com.runcode.gadsleaderboard.pojo.IQLearner;
import com.runcode.gadsleaderboard.pojo.LearningHoursLearner;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LearnerLeaderAdapter extends RecyclerView.Adapter<LearnerLeaderAdapter.LearnerLeaderViewHolder> {

    private List<LearningHoursLearner> items;

    public LearnerLeaderAdapter() {
    }

    @Override
    public LearnerLeaderViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.learner_item, parent, false);
        return new LearnerLeaderViewHolder(v);
    }
    public void setItems (List<LearningHoursLearner> items)
    {
        this.items = items ;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(LearnerLeaderViewHolder holder, int position) {
        LearningHoursLearner item = items.get(position);
        //TODO Fill in your logic for binding the view.
        holder.name.setText(item.getName());
        String details = item.getHours() + " Learning hours " + item.getCountry();
        holder.details.setText(details);
        Picasso.get()
                .load(item.getBadgeUrl())
                .into(holder.badgeImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.mProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Exception e) {
                        holder.badgeImage.setImageResource(R.drawable.ic_error_24);
                    }
                });
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }


    public static class LearnerLeaderViewHolder extends RecyclerView.ViewHolder {
        TextView name  , details;
        ImageView badgeImage ;
        ProgressBar mProgressBar ;
        public LearnerLeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.learnerName);
            details = itemView.findViewById(R.id.learnerScore_hours);
            badgeImage = itemView.findViewById(R.id.badge_image);
            mProgressBar = itemView.findViewById(R.id.bar);
        }
    }
}